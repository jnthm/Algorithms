package arrays

import scala.collection.mutable.ArrayBuffer

object Reservoir extends App {

  def reservoirSampling(A: Iterator[Int], k: Int): ArrayBuffer[Int] = {
    // put k elements into result
    val result = new ArrayBuffer[Int](k)
    while (A.hasNext && result.length < k) {
      result += A.next
    }

    var i = result.size
    while (A.hasNext) {
      val r = scala.util.Random.nextInt(i + 1)
      i += 1
      if (r < k)
        result(r) = A.next
    }
    result
  }

  println(reservoirSampling(Array(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4).toIterator, 4))

}


