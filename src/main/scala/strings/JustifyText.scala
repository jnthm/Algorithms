package strings

import scala.collection.mutable.ListBuffer

object JustifyText extends App {


  case class Sentence(word: String, var gap: Int)

  def justifyText(words: Array[String], L: Int): ListBuffer[String] = {

    val finalResult = ListBuffer[String]()
    var remaining = L
    var partialResult = ListBuffer[Sentence]()
    var i = 0
    while (i < words.length) {

      val currWord = words(i)

      if (remaining > currWord.length) {
        partialResult += Sentence(currWord, 0)
        remaining -= (currWord.length + 1)
        i += 1
      } else if (remaining == currWord.length) {
        partialResult += Sentence(currWord, 0)
        remaining -= currWord.length
        i += 1
      }
      if (remaining <= currWord.length) {
        // calculate spaces
        val minGap = if (partialResult.length > 1) (L - partialResult.map(_.word.length).sum) / (partialResult.length - 1) else 0
        var additionalGaps = if (partialResult.length > 1) (L - partialResult.map(_.word.length).sum) % (partialResult.length - 1) else 0

        // add minGaps
        partialResult.foreach(s => s.gap = minGap)
        partialResult(partialResult.size - 1).gap = 0
        // add additionalGaps
        var j = 0
        while (additionalGaps > 0) {
          partialResult(j).gap += 1
          additionalGaps -= 1
          j = (j + 1) % (partialResult.length - 1)
        }

        val finalTempString = new StringBuilder()
        for (j <- 0 until partialResult.length) {
          finalTempString.append(partialResult(j).word + " " * partialResult(j).gap)
        }
        finalResult += finalTempString.toString()
        remaining = L
        partialResult = ListBuffer[Sentence]()
      }
    }

    finalResult
  }

  val words = Array("My", "name", "is", "Jayanth", "M")
  val words1 = Array("This", "is", "an", "example", "of", "text", "justification.")
  println(justifyText(words1, 16))
  println(justifyText(words1, 14))
  println(justifyText(words, 10))

}

