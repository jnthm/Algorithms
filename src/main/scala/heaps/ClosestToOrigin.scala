package heaps

import scala.collection.mutable.ListBuffer


case class Star(x: Int, y: Int, z: Int) {
  def distance: Double = {
    math.sqrt(x * x + y * y + z * z)
  }
}

object StarOrdering extends Ordering[Star] {
  val origin = Star(0, 0, 0)

  override def compare(x: Star, y: Star) = x.distance.compare(y.distance)
}


class ClosestToOrigin {

  def findClosestStarsToOrigin(stars: Iterator[Star], k: Int): List[Star] = {
    val maxHeap = scala.collection.mutable.PriorityQueue[Star]()(StarOrdering)
    while (stars.hasNext) {
      maxHeap += stars.next()
      if (maxHeap.size > k) {
        maxHeap.dequeue()
      }
    }
    maxHeap.toList.sorted(StarOrdering)
  }
}


object ClosestToOriginTest extends App {
  val stars = ListBuffer[Star]()
  stars += Star(1, 2, 3)
  stars += Star(5, 5, 5)
  stars += Star(0, 2, 1)
  stars += Star(9, 2, 1)
  stars += Star(1, 2, 1)
  stars += Star(2, 2, 1)
  println(new ClosestToOrigin().findClosestStarsToOrigin(stars.toIterator, 3).mkString(", "))
}
