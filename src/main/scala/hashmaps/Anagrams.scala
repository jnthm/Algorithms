package hashmaps

object Anagrams extends App{

  def findAnagrams(A: List[String]): Seq[Seq[String]] = {
    val finalMap = scala.collection.mutable.Map[String, List[String]]()
    A.foreach {
      case (e : String) =>
        val sortedE = e.sorted
        val existingVal = finalMap.getOrElse(sortedE, List[String]())
        finalMap.put(sortedE, e :: existingVal)
    }
    finalMap.values.filter(_.length > 1).toSeq
  }

  val in = List("debit card", "bad credit", "the morse code",
    "here come dots", "the eyes", "they see", "THL")

  val result = findAnagrams(in)
  assert(result.size == 3)

}
