package hashmaps

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

class TopKBucketSort {

  def topk(A: ArrayBuffer[Int], k: Int): ArrayBuffer[Int] = {
    val countMap = Map[Int, Int]()
    A.foreach(elem => countMap.put(elem, countMap.getOrElse(elem, 0) + 1))
    val freqBucketArray = ArrayBuffer.fill[Int](A.length)(0)
    countMap.foreach { case (k, v) => freqBucketArray(v) = k }
    val resultBuffer = new ArrayBuffer[Int]()
    for (i <- freqBucketArray.length - 1 to 0 by -1 if freqBucketArray(i) > 0 && resultBuffer.length < k)
      resultBuffer += freqBucketArray(i)
    resultBuffer
  }

}

object TopKBucketSortTest extends App {
  println(new TopKBucketSort().topk(ArrayBuffer(1, 1, 1, 2, 2, 3), 2))
}
