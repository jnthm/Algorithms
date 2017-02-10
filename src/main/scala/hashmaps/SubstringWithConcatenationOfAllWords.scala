package hashmaps

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class SubstringWithConcatenationOfAllWords {
  def findAllSubstrings(s: String, words: Array[String]): Seq[Int] = {
    val resultBuffer = ArrayBuffer[Int]()
    for (i <- 0 until s.length) {
      if (areAllStringsPresent(s, words, i)) {
        resultBuffer += i
      }
    }
    resultBuffer
  }

  private def areAllStringsPresent(s: String, words: Array[String], index: Int): Boolean = {
    val wordLength = words(0).length

    if ((index + wordLength * words.length) > s.length) {
      return false
    }

    val subStringSet = words.toSet

    var i = index
    while (i < index + words.length * wordLength) {
      if (!subStringSet.contains(s.substring(i, i + wordLength))) {
        return false
      }
      i += wordLength
    }
    true
  }
}

object SubstringWithConcatenationOfAllWordsTest extends App {

  println(new SubstringWithConcatenationOfAllWords().findAllSubstrings("barfoothefoobarman", Array("foo", "bar")).mkString(", "))

}
