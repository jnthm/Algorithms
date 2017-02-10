package searching


object BinarySearchFirstK extends App {
  def getFirstOccurrence(in: Array[Int], k: Int): Int = {
    var left = 0
    var right = in.length - 1
    while (left < right) {
      val mid = left + (right - left) / 2
      if (k > in(mid)) {
        left = mid + 1
      } else if (k < in(mid)) {
        right = mid - 1
      } else {
        right = mid
      }
    }

    in(left) match {
      case `k` => left
      case _ => -1
    }
  }

  val in = Array(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401)
  assert(getFirstOccurrence(in, 108) == 3)
  assert(getFirstOccurrence(in, 285) == 6)
  assert(getFirstOccurrence(in, 286) == -1)

}
