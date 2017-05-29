import scala.collection.mutable.ListBuffer


/**
  * M -> length of the phone number
  * N -> combination Mappings of digits to alpha
  * *
  * N pow M
  *
  */
object PhoneNumberMapping extends App {

  val keyMap = Array("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

  def getLetterCombinations(phoneNum: String): ListBuffer[String] = {
    val finalResult = ListBuffer[String]()
    val partialResult = new Array[Char](phoneNum.length)
    letterCombinationsHelper(phoneNum, 0, partialResult, finalResult)
    finalResult
  }

  private def letterCombinationsHelper(phoneNum: String, index: Int, partialResult: Array[Char], finalResult: ListBuffer[String]): Unit = {
    // base case
    if (index == phoneNum.length) {
      finalResult += new String(partialResult)
    } else {
      // recursive case
      val phoneNumArr = phoneNum.toCharArray
      val mapping = keyMap(phoneNumArr(index) - '0').toCharArray
      for (i <- 0 until mapping.length) {
        val currChar = mapping(i)
        partialResult(index) = currChar
        letterCombinationsHelper(phoneNum, index + 1, partialResult, finalResult)
      }
    }
  }

  println(getLetterCombinations("123"))
}


