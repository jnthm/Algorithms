package hashmaps

import scala.collection.mutable.Map

class LongestContainedRange {
  val rangeMap = Map[Int, Int]()

  def findLongestContainedRangeInt(in: Array[Int]): Int = {
    if (in.isEmpty) return 0

    val inputSet = in.toSet
    var maxLen = Int.MinValue
    for (i <- 0 until in.length)
      maxLen = scala.math.max(recursionHelper(in(i), inputSet), maxLen)
    maxLen
  }

  def recursionHelper(value: Int, inputSet: Set[Int]): Int = {
    if (!inputSet.contains(value)) return 0
    if (rangeMap.get(value).isEmpty) {
      rangeMap += (value -> (recursionHelper(value - 1, inputSet) + 1))
    }
    rangeMap(value)

  }


}

object LongestContainedRangeTest extends App {
  println(new LongestContainedRange().findLongestContainedRangeInt(Array(3, -2, 7, 9, 8, 1, 2, 0)))
}
