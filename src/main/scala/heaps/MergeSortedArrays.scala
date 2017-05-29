package heaps

import scala.collection.mutable.ArrayBuffer



class MergeSortedArrays {

  case class HeapNode(arrayId: Int, elem: Int, arrayOffset: Int) extends Ordered[HeapNode] {
    override def compare(that: HeapNode) = that.elem.compare(this.elem)
  }

  def mergeSortedArrays(sortedArrays: Array[Array[Int]]): ArrayBuffer[Int] = {
    val minHeap = scala.collection.mutable.PriorityQueue[HeapNode]()

    val resultBuffer = ArrayBuffer[Int]()

    // put in 1st elements of each array
    for (i <- 0 until sortedArrays.length if sortedArrays(i).length > 0)
      minHeap += HeapNode(i, sortedArrays(i)(0), 0)

    while (minHeap.nonEmpty) {
      val heapNode = minHeap.dequeue()
      resultBuffer += heapNode.elem
      val nextOffset = heapNode.arrayOffset + 1
      if (nextOffset < sortedArrays(heapNode.arrayId).length) {
        minHeap += HeapNode(heapNode.arrayId, sortedArrays(heapNode.arrayId)(nextOffset), nextOffset)
      }
    }
    resultBuffer
  }

}

object MergeSortedArraysTest extends App {

  val in = Array(
    Array(1, 5, 10), Array(2, 3, 100), Array(2, 12, Integer.MAX_VALUE)
  )

  println(new MergeSortedArrays().mergeSortedArrays(in).mkString(", "))


}
