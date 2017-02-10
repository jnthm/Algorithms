package hashmaps

import java.util.{Comparator, PriorityQueue}
import scala.collection.JavaConverters._


trait TopKOrdering {
  def topKOrdering(countMap: scala.collection.mutable.Map[String, Int], k: Int): Seq[String]
}

class TopkQueries extends TopKOrdering {

  private def getCounts(queries: Array[String]): scala.collection.mutable.Map[String, Int] = {
    val queryCounts = scala.collection.mutable.Map[String, Int]()
    queries.foreach { q =>
      if (queryCounts.get(q).isDefined) queryCounts.put(q, queryCounts(q) + 1)
      else queryCounts.put(q, 1)
    }
    queryCounts
  }

  def topKOrderingJavaPq(countMap: scala.collection.mutable.Map[String, Int], k: Int): Seq[String] = {
    val a = new PriorityQueue[(String, Int)](k, new Comparator[(String, Int)] {
      override def compare(o1: (String, Int), o2: (String, Int)) = o1._2 - o2._2
    })
    countMap.foreach { case (s: String, v: Int) => a.add((s, v))
      if (a.size() > k) a.poll()
    }
    a.asScala.toList.map(_._1)
  }

  def topKOrdering(countMap: scala.collection.mutable.Map[String, Int], k: Int): Seq[String] = {
    val a = scala.collection.mutable.PriorityQueue.empty[(String, Int)](Ordering.by[(String, Int), Int](_._2).reverse)
    countMap.foreach { case (s: String, v: Int) => a.enqueue((s, v))
      if (a.size > k) a.dequeue()
    }
    a.map(_._1).toList
  }

  def getTopkQueries(queries: Array[String], k: Int): Seq[String] = {
    topKOrdering(countMap = getCounts(queries), k)
  }
}

object Test extends App {
  val in = Array("1", "1", "1", "2", "2", "2", "2", "2", "2", "2", "2", "3", "3", "4")
  val a = new TopkQueries
  print(a.getTopkQueries(in, 2))
}
