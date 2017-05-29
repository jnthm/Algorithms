package bst

import scala.collection.mutable.Stack

case class BstNode(data: Int, var left: Option[BstNode], var right: Option[BstNode])

class BSTIterator(root: BstNode) extends Iterator[BstNode] {

  val stack = Stack[BstNode]()
  pushLeftNodes(Some(root))

  private def pushLeftNodes(root: Option[BstNode]) = {
    var curr = root
    while (curr.isDefined) {
      stack.push(curr.get)
      curr = curr.get.left
    }
  }

  override def next(): BstNode = {
    val returnNode = stack.pop()
    pushLeftNodes(returnNode.right)
    returnNode
  }

  override def hasNext: Boolean = stack.nonEmpty

}

object BSTIteratorTest extends App {

  val root = BstNode(4, None, None)
  root.left = Some(BstNode(2, None, None))
  root.right = Some(BstNode(6, None, None))
  root.left.get.left = Some(BstNode(1, None, None))
  root.left.get.right = Some(BstNode(3, None, None))
  root.right.get.left = Some(BstNode(5, None, None))
  root.right.get.right = Some(BstNode(7, None, None))


  val iter = new BSTIterator(root)
  while (iter.hasNext) {
    println(iter.next().data)
  }
}
