package arrays

import scala.collection.mutable.ArrayBuffer

case class ArrayNode(k: String, v: Int)

class PartitionArray {

  private def swap(A: ArrayBuffer[ArrayNode], from: Int, to: Int): Unit = {
  }


  def inPlacePartitions(A: ArrayBuffer[ArrayNode]): Unit = {
    // TODO: basic error checking
    var negPointer = 0
    var posPointer = 0

    while (negPointer < A.length) {

      // traverse negPointer to reach negValue
      while (A(negPointer).v >= 0) {
        negPointer += 1
      }

      // traverse posPointer to reach posValue with index greater than negPointer
      while (posPointer < A.length && A(posPointer).v >= 0 && posPointer > negPointer) {
        posPointer += 1
      }

      swap(A, negPointer, posPointer)
      negPointer += 1
      posPointer += 1

    }


  }

}