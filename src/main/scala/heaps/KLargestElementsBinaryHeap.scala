package heaps

import scala.collection.mutable.ArrayBuffer


class KLargestElementsBinaryHeap {

  case class HeapNode(arrayIndex: Int, elem: Int)

  def kLargestInBinaryHeap(heapArray: Array[Int], k: Int): ArrayBuffer[Int] = {
    val resultBuffer = ArrayBuffer[Int]()
    if (heapArray.isEmpty || heapArray.length < k) return resultBuffer
    val resultHeap = scala.collection.mutable.PriorityQueue[HeapNode]()(Ordering.by[HeapNode, Int](_.elem))
    resultHeap += HeapNode(0, heapArray(0))

    while (resultBuffer.length < k) {
      val heapNode = resultHeap.dequeue()
      resultBuffer += heapNode.elem
      val nextIndices = (2 * heapNode.arrayIndex + 1, 2 * heapNode.arrayIndex + 2)
      if (nextIndices._1 < heapArray.length && resultHeap.size < k)
        resultHeap += HeapNode(nextIndices._1, heapArray(nextIndices._1))
      if (nextIndices._2 < heapArray.length && resultHeap.size < k)
        resultHeap += HeapNode(nextIndices._2, heapArray(nextIndices._2))
    }
    resultBuffer
  }

}

object KLargestElementsBinaryHeapTest extends App {
  val in1 = Array(10, 2, 9, 2, 2, 8, 8, 2, 2, 2, 2, 7, 7, 7, 7)
  val in2 = Array(97, 84, 93, 83, 81, 90, 79, 83, 55, 42, 21, 73)
  val in3 = Array(100, 1, 5, 0, 0)
  println(new KLargestElementsBinaryHeap().kLargestInBinaryHeap(in1, 3).mkString(", "))
  println(new KLargestElementsBinaryHeap().kLargestInBinaryHeap(in2, 3).mkString(", "))
  println(new KLargestElementsBinaryHeap().kLargestInBinaryHeap(in3, 1).mkString(", "))
  println(new KLargestElementsBinaryHeap().kLargestInBinaryHeap(in3, 2).mkString(", "))
  println(new KLargestElementsBinaryHeap().kLargestInBinaryHeap(in3, 3).mkString(", "))

}
