package hashmaps

import scala.collection.mutable.Map

class LongestSubarrayWithDistinctEntries {

  def longestSubarrayWithDistinctEntries(in: Array[Int]): (Int, Int) = {
    if (in.isEmpty)
      return (-1, -1)

    var lastFoundIndex = Map[Int, Int]()
    var left = 0; var right = 1; var finalLongest = (0, 0)
    lastFoundIndex += (in(left) -> left)
    while (right < in.length) {
      if (lastFoundIndex.get(in(right)).isDefined) {
        if ((right - left) > (finalLongest._2 - finalLongest._1)) {
          finalLongest = (left, right - 1)
        }
        left = lastFoundIndex(in(right)) + 1
      }
      lastFoundIndex += (in(right) -> right)
      right += 1
    }
    finalLongest
  }

}

object LongestSubarrayWithDistinctEntriesTest extends App {
  val in = Array(5, 7, 5, 11, 12, 2, 11, 19, 2, 11)
  println(new LongestSubarrayWithDistinctEntries().longestSubarrayWithDistinctEntries(in))
}
