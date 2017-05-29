package recursion

import scala.collection.mutable.ListBuffer

class CombinationsSizeK {

  def combinations(n: Int, k: Int): ListBuffer[ListBuffer[Int]] = {
    val result = ListBuffer[ListBuffer[Int]]()
    helper(n, k, 1, result, ListBuffer[Int]())
    result
  }

  def helper(n: Int, k: Int, offset: Int, result: ListBuffer[ListBuffer[Int]], partialResult: ListBuffer[Int]): Unit = {
    if (partialResult.size == k) {
      result += ListBuffer[Int](partialResult: _*)
    } else {
      for (i <- offset to n) {
        partialResult += i
        helper(n, k, i + 1, result, partialResult)
        partialResult -= i
      }
    }
  }


}

object CombinationsSizeK extends App {
  println(new CombinationsSizeK().combinations(4, 2))
}
