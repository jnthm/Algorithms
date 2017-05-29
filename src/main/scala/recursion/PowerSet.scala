package recursion

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class PowerSet {

  def getPowerSetRecursive(inputSet: ArrayBuffer[Char]): ListBuffer[ListBuffer[Char]] = {
    val result = ListBuffer[ListBuffer[Char]]()
    helper(inputSet, result, 0, ListBuffer[Char]())
    result
  }

  private def helper(inputSet: ArrayBuffer[Char],
                     result: ListBuffer[ListBuffer[Char]],
                     currIndex: Int,
                     partialResult: ListBuffer[Char]): Unit = {

    if (currIndex == inputSet.size) {
      result += ListBuffer(partialResult: _*)
    } else {
      // add index
      helper(inputSet, result, currIndex + 1, partialResult += inputSet(currIndex))
      // remove index
      partialResult.remove(partialResult.length - 1)
      helper(inputSet, result, currIndex + 1, partialResult)
    }
  }

}

object PowerSetTest extends App {
  println(new PowerSet().getPowerSetRecursive(ArrayBuffer('a', 'b', 'c')))
}
