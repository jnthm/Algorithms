package searching

import scala.collection.mutable.ArrayBuffer

object QuickSelect extends App {


  private def swap(A: ArrayBuffer[Int], i: Int, j: Int): Unit = {
    val p = A(i)
    A(i) = A(j)
    A(j) = p
  }

  private def quickSelectHelper(A: ArrayBuffer[Int], left: Int, right: Int, pivot: Int): Boolean = {
    var l = left
    var r = right
    var swapped = false

    while (l < r) {
      while (A(l) <= A(pivot) && l < pivot)
        l += 1
      while (A(r) > A(pivot) && r > pivot)
        r -= 1

      swap(A, l, r)
      if (l < pivot) {
        l += 1
        swapped = true
      }
      if (r > pivot) {
        r += 1
        swapped = true
      }
    }
    swapped

  }

  def quickSelect(A: ArrayBuffer[Int], k: Int): Unit = {
    import scala.util.control.Breaks._

    if (k > A.length)
      throw new IllegalArgumentException("Given k is less than Array's length")

    val pivot = k 

    breakable {
      while (true) {
        if (!quickSelectHelper(A, 0, A.length - 1, pivot)) {
          break
        }
      }
    }
  }


  val arr = ArrayBuffer(7, 8, 5, 6, 2, 1, 3, 4, 9)
  quickSelect(arr, 4)
  println(arr.toString())
}
