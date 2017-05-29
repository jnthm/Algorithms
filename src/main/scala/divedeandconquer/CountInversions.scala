package divedeandconquer

import scala.collection.mutable.ArrayBuffer

class CountInversions {
  def countInversions(A: ArrayBuffer[Int]): Int = {
    helper(A, 0, A.length)
  }

  /**
    *
    * @param start
    * @param end exclusive
    * @return
    */
  private def helper(A: ArrayBuffer[Int], start: Int, end: Int): Int = {
    // TODO:
    if (start + 1 >= end) 0
    else {
      val mid = start + (end - start) / 2

      getMergeCounts(A, start, mid, end) + helper(A, start, mid) + helper(A, mid, end)
    }
  }

  /**
    * start -> mid - 1
    * mid -> end - 1
    */
  private def getMergeCounts(A: ArrayBuffer[Int], start: Int, mid: Int, end: Int): Int = {
    val sortedBuffer = new ArrayBuffer[Int](end - start + 1)
    var leftStart = start
    val leftEnd = mid - 1
    var rightStart = mid
    val rightEnd = end - 1
    var invCount = 0
    var auxBufferIndex = 0

    while (leftStart <= leftEnd && rightStart <= rightEnd) {
      if (A(leftStart) < A(rightStart)) {
        sortedBuffer(auxBufferIndex) = A(leftStart)
        auxBufferIndex += 1
        leftStart += 1
      } else {
        sortedBuffer(auxBufferIndex) = A(rightStart)
        auxBufferIndex += 1
        rightStart += 1
        invCount += (leftEnd - leftStart + 1)
      }
    }

    if (leftStart <= leftEnd) {
      sortedBuffer ++ A.slice(leftStart, leftEnd + 1)
    } else if (rightStart <= rightEnd) {
      sortedBuffer ++ A.slice(rightStart, rightEnd + 1)
    }

    // put back sortedBuffer into A
    for (i <- start until start + sortedBuffer.length)
      A(i) = sortedBuffer(i)

    invCount

  }

}
