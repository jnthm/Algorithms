package searching

object MatrixSearch extends App {

  def matrixSearch(A: Array[Array[Int]], k: Int): (Int, Int) = {

    var r = 0
    var c = A(0).length - 1

    while (r >= 0 && c <= A.length - 1) {
      if (A(r)(c) == k)
        return (r, c)
      else if (A(r)(c) > k)
        c -= 1
      else
        r += 1
    }

    (-1, -1)
  }

  val arr = Array.ofDim[Int](3, 3)
  arr(0) = Array(1, 2, 3)
  arr(1) = Array(4, 5, 6)
  arr(2) = Array(7, 8, 9)

  println(matrixSearch(arr, 9))
  println(matrixSearch(arr, 8))
  println(matrixSearch(arr, 1))
}
