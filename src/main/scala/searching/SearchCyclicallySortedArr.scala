package searching

object SearchCyclicallySortedArr extends App {

  def searchCyclicallySortedArray(inputArr: Array[Int]): Int = {

    var left = 0
    var right = inputArr.length - 1

    while (left < right) {
      val mid = left + (right - left) / 2
      if (inputArr(right) > inputArr(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }

  var inputArray = Array(378,478,550,631,103,203,220,234,279,368)
  assert(searchCyclicallySortedArray(inputArray) == 4)

}
