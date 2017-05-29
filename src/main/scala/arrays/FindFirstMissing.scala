package arrays

import scala.collection.mutable.ArrayBuffer

object Solution extends App {

  def findFirstMissingTake1(arr: Array[Int]): Int = {
    var i = 0
    while (i < arr.length) {
      if (arr(i) != i + 1) {
        return i + 1
      }
      i += 1
    }
    i + 1
  }

  def findFirstMissing(arr: Array[Int]): Int = {
    if (arr.isEmpty)
      return 1


    var left = 0
    var right = arr.length - 1
    while (left < right) {
      var mid = left + (right - left) / 2
      if (arr(mid) == mid + 1) {
        left = mid + 1
      } else {
        right = mid
      }
    }

    if (arr(left) == left + 1)
      left + 2
    else
      left + 1
  }


  def findFirstMissingUnsortedEpi(arr: ArrayBuffer[Int]): Int = {

    def swap(A: ArrayBuffer[Int], from: Int, to: Int) = {
      val temp = A(from)
      A(from) = A(to)
      A(to) = temp
    }

    var i = 0
    while (i < arr.size) {
      if (arr(i) > 0 && arr(i) <= arr.size && arr(i) != arr(arr(i) - 1)) {
        swap(arr, from = i, to = arr(i) - 1)
      } else {
        i += 1
      }
    }


    // iterate
    arr.zipWithIndex.find { case (v, index) => v != index + 1 } match {
      case Some(t) => t._2 + 1
      case None => arr.size + 1
    }

  }

  //  println(findFirstMissing(Array(1, 2, 3, 4, 7, 8, 9))) // 5
  //
  //  println(findFirstMissing(Array(1, 2, 3, 4))) // 5
  //
  //  println(findFirstMissing(Array(7, 8, 9))) // 1
  println(findFirstMissingUnsortedEpi(ArrayBuffer(3, 5, 4, -1, 5, 1, -1))) // 1
  println(findFirstMissingUnsortedEpi(ArrayBuffer(1, 2, 3, 4, 5, 6, 7))) // 1

  //  println(findFirstMissing(Array())) // 1


}