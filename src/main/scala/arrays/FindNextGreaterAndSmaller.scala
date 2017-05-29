package arrays

import scala.collection.mutable.ListBuffer

object FindNextGreaterAndSmaller extends App {

  def findNextGreater(A: ListBuffer[Int]): ListBuffer[Int] = {

    val lastElem = A.last
    var result = ListBuffer[Int]()

    // find smaller than last elem
    var i = A.size - 2
    while (i >= 0 && A(i) >= lastElem) {
      i -= 1
    }

    if (i < 0) return result

    result ++= A.slice(0, i)
    result += lastElem
    result ++= A.slice(i, A.size - 1).sorted
    result
  }

  println(findNextGreater(ListBuffer(2, 1, 8, 7, 6, 5)))
  println(findNextGreater(ListBuffer(1, 2, 3, 4)))
  println(findNextGreater(ListBuffer(4, 3, 2, 1)))
  println(findNextGreater(ListBuffer(5, 3, 4, 9, 7, 6)))

}
