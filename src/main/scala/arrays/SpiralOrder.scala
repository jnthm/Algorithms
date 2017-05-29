package arrays

object SpiralOrder extends App {

  def spiralPrint(A: Array[Array[Int]]): Unit = {
    var rowStart = 0
    var rowEnd = A.length - 1
    var colStart = 0
    var colEnd = A.length - 1

    while (rowStart <= rowEnd && colStart <= colEnd) {

      // print rows left to right
      for (i <- colStart to colEnd) {
        print(A(rowStart)(i))
        print(" ")
      }
      rowStart += 1

      // print col top to bottom
      for (i <- rowStart to rowEnd) {
        print(A(i)(colEnd))
        print(" ")
      }
      colEnd -= 1

      // print row right to left
      for (i <- colEnd to colStart by -1) {
        print(A(rowEnd)(i))
        print(" ")
      }
      rowEnd -= 1

      // print col bottom to top
      for (i <- rowEnd to rowStart by -1) {
        print(A(i)(colStart))
        print(" ")
      }
      colStart += 1

    }


  }

  //spiralPrint(Array(Array(1, 2, 3, 4), Array(5, 6, 7, 8), Array(9, 10, 11, 12), Array(13, 14, 15, 16)))
  spiralPrint(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7,8,9)))
  spiralPrint(Array(Array(1)))

}

