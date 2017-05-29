package searching

object BinarySearchUnknownLength extends App {

  def binarySearchUnknownLength(inputArray: Array[Int], k: Int): Int = {
    var p = 0
    var start = 0
    var end = 0

    import scala.util.control.Breaks._
    breakable {
      while (true) {
        try {
          end = (p << 1) - 1 // 2^p - 1
          if (inputArray(end) == k) {
            return k
          } else if (inputArray(end) > k) {
            break
          }
          start = end + 1
        } catch {
          case e: ArrayIndexOutOfBoundsException => break
        }
        p += 1
      }
    }

    binarySearchUnknownLengthHelper(inputArray, start, end, k)

  }

  private def binarySearchUnknownLengthHelper(inputArray: Array[Int], start: Int, end: Int, k: Int): Int = {

    var left = start
    var right = end

    while (left < right) {
      val mid = left + (right - left) / 2

      try {
        if (inputArray(mid) == k) {
          return mid
        } else if (inputArray(mid) < k) {
          left = mid + 1
        } else {
          right = mid - 1
        }
      } catch {
        case e: ArrayIndexOutOfBoundsException =>
          right = mid - 1
      }
    }
    -1
  }


}
