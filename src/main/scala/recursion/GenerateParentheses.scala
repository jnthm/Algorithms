package recursion

import scala.collection.mutable.ListBuffer

class GenerateParentheses {

  def generateBalancedParentheses(numPairs: Int): ListBuffer[String] = {
    val result = ListBuffer[String]()
    helper(result, numPairs * 2, 0, "")
    result
  }

  def helper(result: ListBuffer[String], remaining: Int, unbalanced: Int, partialString: String): Unit = {
    if (remaining == 0) {
      result += partialString
    } else {
      if (unbalanced > 0)
        helper(result, remaining - 1, unbalanced - 1, partialString + ")")
      if (remaining >= 2 * unbalanced)
        helper(result, remaining - 1, unbalanced + 1, partialString + "(")
    }
  }

}

object GenerateParenthesesTest extends App {
  println(new GenerateParentheses().generateBalancedParentheses(3))
}
