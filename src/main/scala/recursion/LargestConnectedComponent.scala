package recursion

/**
  * Question asked in Doordash
  */
object LargestConnectedComponent extends App {

  def findLargestConnectedComponent(A: Array[Array[Int]], targetVal: Int): Int = {
    val markerMatrix = Array.ofDim[Boolean](A.length, A(0).length)


    var finalMax = 0
    for (i <- 0 until A.length) {
      for (j <- 0 until A(0).length) {
        if (!markerMatrix(i)(j)) {
          finalMax = math.max(finalMax, findLargestConnectedComponentHelper(A, targetVal, markerMatrix, i, j))
        }
      }
    }

    finalMax
  }

  private def findLargestConnectedComponentHelper(A: Array[Array[Int]], targetVal: Int, markerMatrix: Array[Array[Boolean]], row: Int, col: Int): Int = {
    if (row < 0 || row >= A.length || col < 0 || col >= A(0).length || markerMatrix(row)(col) || A(row)(col) != targetVal)
      0
    else {
      markerMatrix(row)(col) = true
      1 + findLargestConnectedComponentHelper(A, targetVal, markerMatrix, row, col - 1) +
        findLargestConnectedComponentHelper(A, targetVal, markerMatrix, row - 1, col) +
        findLargestConnectedComponentHelper(A, targetVal, markerMatrix, row, col + 1) +
        findLargestConnectedComponentHelper(A, targetVal, markerMatrix, row + 1, col)

    }
  }

  val m1 = Array(Array(3, 3, 3, 3), Array(3, 4, 4, 4), Array(3, 4, 5, 6), Array(4, 4, 4, 4))
  val m2 = Array(Array(4, 4, 4, 4, 4), Array(3, 4, 4, 4, 4), Array(6, 6, 6, 6, 6), Array(3, 4, 4, 4, 5), Array(3, 4, 5, 6, 6), Array(4, 4, 4, 4, 7))
  println(findLargestConnectedComponent(m1, 3))
  println(findLargestConnectedComponent(m1, 4))
  println(findLargestConnectedComponent(m2, 4))


  /*
    4 4 4 4 4
    3 4 4 4 4
    6 6 6 6 6
    3 4 4 4 5
    3 4 5 6 6
    4 4 4 4 7
   */

}
