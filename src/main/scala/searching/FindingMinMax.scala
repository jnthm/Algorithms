package searching

case class MinMax(min: Int, max: Int)

object MinMax {
  def getMinMax(a: Int, b: Int): MinMax = if (a < b) MinMax(a, b) else MinMax(b, a)
}

object FindingMinMax extends App {

  def finMinMax(A: Array[Int]): MinMax = {

    if (A.length <= 1)
      return MinMax(A(0), A(0))

    var globalMinMax = MinMax.getMinMax(A(0), A(1))

    var i = 2
    while (i + 1 < A.length) {
      val localMinMax = MinMax.getMinMax(A(i), A(i + 1))
      globalMinMax = MinMax(math.min(globalMinMax.min, localMinMax.min), math.max(globalMinMax.max, localMinMax.max))
      i += 1
    }

    if (i < A.length)
      globalMinMax = MinMax(math.min(globalMinMax.min, A(i)), math.max(globalMinMax.max, A(i)))

    globalMinMax
  }

  val arr = Array(2, 3, 1, 6, 8, 9, 4, -1, 7, 14, 5)
  println(finMinMax(arr).toString)

}
