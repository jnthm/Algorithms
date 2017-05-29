package hashmaps

object CanStringBePalindromeHash extends App {

  def canFormPalindromeHash(s: String): Boolean = {
    val charArray = s.toCharArray
    val charMap = scala.collection.mutable.Map[Char, Int]()
    charArray.foreach { case (c: Char) => charMap.put(c, charMap.getOrElse(c, 0) + 1) }
    var oddCount = 0
    charMap.values.foreach { case (e: Int) => if (e % 2 == 1) oddCount += 1 }
    oddCount <= 1
  }

  def canFormPalindromeSort(s: String): Boolean = {
    val charArraySorted = s.toCharArray.sorted
    if (charArraySorted.length <= 1) return true

    var left = 0
    var right = 0
    var oddCount = 0

    while (right < charArraySorted.length && oddCount <= 1) {
      while (right < charArraySorted.length && charArraySorted(right) == charArraySorted(left)) {
        right += 1
      }
      val numEqChars = right - left
      if (numEqChars % 2 == 1) oddCount += 1
      left = right
    }

    oddCount <= 1
  }

  assert(canFormPalindromeHash("edified"))
  assert(canFormPalindromeHash("liril"))

  assert(canFormPalindromeSort("edified"))
  assert(canFormPalindromeSort("liril"))
}
