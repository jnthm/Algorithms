package arrays

object MatrixDiagonal extends App {

  def printDiagonal(A: Array[Array[Int]]): Unit = {
    val R = A.length
    val C = A(0).length
    for (i <- 0 until (R + C - 1)) {
      var row = math.min(i, R - 1)
      var col = math.max(0, i - R + 1)
      while (row >= 0 && col < C) {
        print(A(row)(col))
        row -= 1
        col += 1
        print(" ")
      }
    }
  }

  printDiagonal(Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16)))

}
