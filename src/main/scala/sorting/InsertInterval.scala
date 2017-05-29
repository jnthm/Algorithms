package sorting

import scala.collection.mutable.ListBuffer

object InsertInterval extends App {

  case class Interval(l: Int, r: Int)

  def addInterval(disjointIntervals: List[Interval], newInterval: Interval): ListBuffer[Interval] = {
    val result = ListBuffer[Interval]()
    var i = 0

    // all intervals before new Interval
    while (i < disjointIntervals.size && disjointIntervals(i).r < newInterval.l) {
      result += disjointIntervals(i)
      i += 1
    }

    // all intervals overlapping with the newInterval
    var tempInterval: Interval = newInterval
    while (i < disjointIntervals.size && disjointIntervals(i).l <= newInterval.r) {
      val currInterval = disjointIntervals(i)
      tempInterval = Interval(math.min(currInterval.l, tempInterval.l), math.max(currInterval.r, tempInterval.r))
      i += 1
    }
    result += tempInterval

    // all intervals after the newInterval
    result ++ disjointIntervals.slice(i, disjointIntervals.length)
  }

}
