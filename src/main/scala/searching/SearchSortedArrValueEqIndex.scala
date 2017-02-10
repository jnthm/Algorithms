package searching

object SearchSortedArrValueEqIndex extends App {

  def findValueEqIndex(inputArray: Array[Int]): Int = {
    var left = 0
    var right = inputArray.length - 1

    while (left <= right) {
      val mid = left + (right - left)/2
      if (mid == inputArray(mid)) {
        return mid
      } else if (mid > inputArray(mid)) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
    -1
  }

  var inputArray = Array(-14, -10, 2, 108, 108, 243, 285, 285, 285, 401)
  assert(findValueEqIndex(inputArray) == 2)
  inputArray = Array(-14, -10, 3, 108, 108, 243, 285, 285, 285, 401)
  assert(findValueEqIndex(inputArray) == -1)
//  assert(findValueEqIndex(inputArray, 285) == 9)
//  assert(findValueEqIndex(inputArray, 500) == -1)

}
