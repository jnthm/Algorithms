package searching

object BinarySearchFirstGreaterThanK extends App{

  def getFirstGreaterThanK(inputArray: Array[Int], k: Int): Int = {

    var left = 0
    var right = inputArray.length - 1

    while (left < right ) {
      val mid = left + (right - left)/2
      if (inputArray(mid) <= k) {
        left = mid + 1
      } else {
        right = mid
      }
    }

    if (inputArray(left) > k) {
      left
    } else {
      -1
    }
  }

  val inputArray = Array(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401)
  assert(getFirstGreaterThanK(inputArray, 101) == 3)
  assert(getFirstGreaterThanK(inputArray, 285) == 9)
  assert(getFirstGreaterThanK(inputArray, 500) == -1)
}
