package hashmaps

import scala.collection.mutable

trait LRUCache {
  def insert(k: String, v: Int): Unit

  def lookup(k: String): Option[Int]
}

case class Node(elem: String, var prev: Option[Node] = None, var next: Option[Node] = None)

object LRUCacheImpl {
  def apply(capacity: Int): LRUCacheImpl = {
    val cacheImpl = new LRUCacheImpl(capacity)
    cacheImpl.lruCache = mutable.Map[String, (Node, Int)]()
    cacheImpl
  }
}

class LRUCacheImpl(capacity: Int) extends LRUCache {

  var lruCache: mutable.Map[String, (Node, Int)] = _
  var head: Node = Node(elem = null)
  var tail: Node = Node(elem = null)
  head.next = Some(tail)
  tail.prev = Some(head)

  private def addNodeToHead(node: Node): Unit = {
    node.prev = Some(head)
    node.next = head.next
    head.next = Some(node)
    node.next.get.prev = Some(node)
  }

  private def deleteNode(node: Node): Unit = {
    node.prev.get.next = node.next
    node.next.get.prev = node.prev
  }

  def insert(k: String, v: Int): Unit = {
    if (lruCache.get(k).isDefined) {
      val existingNode = lruCache(k)._1
      deleteNode(existingNode)
    }

    val nodeToBeInserted = Node(k)
    addNodeToHead(nodeToBeInserted)
    lruCache.put(k, (nodeToBeInserted, v))

    if (lruCache.size >= capacity) {
      val nodeToBeDeleted = tail.prev.get
      deleteNode(nodeToBeDeleted)
      lruCache.remove(nodeToBeDeleted.elem)
    }
  }

  def lookup(k: String): Option[Int] = {
    if (lruCache.get(k).isEmpty)
      None
    else {
      val (node, v) = lruCache(k)
      deleteNode(node)
      addNodeToHead(node)
      Some(v)
    }
  }
}

object LRUCacheTest extends App {
  val cache = LRUCacheImpl(10)
  cache.insert("1", 111)
  cache.insert("2", 2)
  cache.insert("3", 3)
  cache.insert("4", 4)
  cache.insert("5", 5)
  cache.insert("6", 6)
  cache.insert("7", 7)
  cache.insert("8", 8)
  cache.insert("9", 9)
  cache.insert("10", 10)
  cache.insert("10", 11)
  assert(cache.lookup("3").get == 3)
  assert(cache.lookup("10").get == 11)
  assert(cache.lookup("1").isDefined)


}
