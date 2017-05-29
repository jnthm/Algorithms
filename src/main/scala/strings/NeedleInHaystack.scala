import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer


object NeedleInHaystack extends App {
  def needleInHaystack(needle: String, haystack: String): List[String] = {
    val result = ListBuffer[String]()
    val needleCountsMap = Map[Char, Int]()
    needle.toCharArray.foreach { c => needleCountsMap.put(c, needleCountsMap.getOrElse(c, 0) + 1) }
    print(needleCountsMap.mkString(" "))

    for (i <- 0 to haystack.length - needle.length) {

      val currHaystackStr = haystack.substring(i, i + needle.length)
      val haystackCountsMap = Map[Char, Int]()
      currHaystackStr.toCharArray.foreach {
        c => haystackCountsMap.put(c, haystackCountsMap.getOrElse(c, 0) + 1)
      }

      var isMatched = true
      haystackCountsMap.foreach {
        case (k, v) => if (!(haystackCountsMap.get(k).isDefined && needleCountsMap.get(k).isDefined
          && haystackCountsMap(k) == needleCountsMap(k))) isMatched = false
      }
      if (isMatched) result += currHaystackStr


    }

    result.toList
  }


  needleInHaystack("iss", "mississippi")

}