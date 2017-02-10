package heaps

class OnlineMedian {

  def onlineMedian(stream: Iterator[Int]): Unit = {
    val minHeap = scala.collection.mutable.PriorityQueue[Int]().reverse
    val maxHeap = scala.collection.mutable.PriorityQueue[Int]()

    val firstVal: Int = stream.next()
    val secondVal = stream.next()

    if (firstVal < secondVal) {
      maxHeap += firstVal
      minHeap += secondVal
    } else {
      minHeap += firstVal
      maxHeap += secondVal
    }

    while (stream.hasNext) {
      val curr = stream.next()

      // enqueue
      if (minHeap.isEmpty) {
        minHeap += curr
      } else {
        if (curr >= minHeap.head) {
          minHeap += curr
        } else if (curr < maxHeap.head) {
          maxHeap += curr
        }
      }

      // balance heaps
      if (maxHeap.size > minHeap.size + 1) {
        minHeap += maxHeap.dequeue()
      } else if (minHeap.size > maxHeap.size + 1) {
        maxHeap += minHeap.dequeue()
      }

      // print median
      println(if (maxHeap.size == minHeap.size) {
        (maxHeap.head + minHeap.head) / 2.0
      } else {
        if (maxHeap.size > minHeap.size) maxHeap.head else minHeap.head
      })
    }

  }

}

object OnlineMedianTest extends App {
  val in = List(5, 4, 3, 2, 1).toIterator
  new OnlineMedian().onlineMedian(in)
}
