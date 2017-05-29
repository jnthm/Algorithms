package sorting

import scala.collection.mutable.ListBuffer


object UnionIntervals extends App {

  case class Interval(l: Int, r: Int) extends Ordered[Interval] {
    override def compare(that: Interval) = l - that.l
  }

  def unionIntervals(intervals: ListBuffer[Interval]): ListBuffer[Interval] = {
    val result = ListBuffer[Interval]()
    val sortedIntervals = intervals.sorted
    result += sortedIntervals.head
    for (i <- 1 until sortedIntervals.length) {
      val lastElem = result.last
      if (sortedIntervals(i).l <= lastElem.r) {
        result.remove(result.size - 1)
        result += Interval(math.min(sortedIntervals(i).l, lastElem.l), math.max(sortedIntervals(i).r, lastElem.r))
      } else {
        result += sortedIntervals(i)
      }
    }

    result
  }

  println(unionIntervals(ListBuffer(Interval(1, 3), Interval(2, 6), Interval(8, 10), Interval(15, 18))))
  println(unionIntervals(ListBuffer(Interval(6, 8), Interval(1, 9), Interval(2, 4), Interval(4, 7))))
}
