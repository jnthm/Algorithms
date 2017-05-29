//package recursion
//
//import scala.collection.mutable.ListBuffer
//
//class Permutations {
//
//  def permutations(A: ListBuffer[Int]): ListBuffer[ListBuffer[Int]] = {
//    val result = ListBuffer[ListBuffer[Int]]()
//    helper(A, 0, result)
//    result
//  }
//
//  private def helper(A: ListBuffer[Int], i: Int, result: ListBuffer[ListBuffer[Int]]): Unit = {
//    if (i == A.size - 1) {
//      result += ListBuffer(A: _*)
//    }
//
//    for (j <- i until A.size) {
//      swap(A, i, j)
//      helper(A, i + 1, result)
//      swap(A, i, j)
//    }
//
//
//  }
//
//}
