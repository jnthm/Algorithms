package queues

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object SlidingWindow extends App {

  def slidingWindowMax(A: Array[Int], k: Int): ArrayBuffer[Int] = {

    val deque = new java.util.ArrayDeque[Int]
    val result = new ArrayBuffer[Int](A.length - k + 1)

    deque.addFirst(A(0))
    for (i <- 1 until A.length) {
      val currElem = A(i)
      while (deque.size > 0 && deque.getFirst <= currElem)
        deque.removeFirst

      deque.addFirst(currElem)

      if (i >= k - 1)
        result += deque.getLast
    }
    result
  }

  println(slidingWindowMax(Array(1, 3, -1, -3, 5, 3, 6, 7), 3))

}




