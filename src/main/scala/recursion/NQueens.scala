package recursion

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class NQueens {

  def nQueens(n: Int): ListBuffer[ArrayBuffer[Int]] = {
    val result = ListBuffer[ArrayBuffer[Int]]()
    helper(n, 0, result, ArrayBuffer[Int]())
    result
  }

  private def isValid(partialResult: ArrayBuffer[Int]): Boolean = {
    val rowID = partialResult.size - 1
    for (i <- 0 until rowID) {
      val diff = math.abs(partialResult(i) - partialResult(rowID))
      if (diff == 0 || diff == rowID - i) {
        return false
      }
    }
    true
  }

  def helper(n: Int, col: Int, result: ListBuffer[ArrayBuffer[Int]], partialResult: ArrayBuffer[Int]): Unit = {

    if (col == n) {
      result += ArrayBuffer[Int](partialResult: _*)
      return
    }

    for (row <- col until n) {
      partialResult += row
      if (isValid(partialResult)) {
        helper(n, row + 1, result, partialResult)
      }
      partialResult.remove(partialResult.size - 1)

    }

  }
}

object NQueensTest extends App {
  println(new NQueens().nQueens(4))
}
