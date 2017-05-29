package graphs

object FindRectangles {


  case class Point(x: Int, y: Int)

  case class Result(p: Point, width: Int, height: Int)

  def findRectangle(A: Array[Array[Int]]): Option[Result] = {
    var topLeft = Point(-1, -1)
    var width = 0
    var height = 0

    var i = 0;
    var j = 0
    while (i < A.length) {
      while (j < A(0).length) {
        if (A(i)(j) == 0) {
          topLeft = Point(i, j)

          var initialJ = j
          while (j < A(0).length && A(i)(j) == 0) {
            width += 1
            j += 1
          }

          while (i < A.length && A(i)(initialJ) == 0) {
            height += 1
            i += 1
          }
          return Some(Result(topLeft, width, height))

        }
        j += 1
      }
      j = 0
      i += 1
    }
    None
  }


  import scala.collection.mutable.ListBuffer

  def findAllRectangles(inputImage: Array[Array[Int]]): ListBuffer[Result] = {
    var topLeft = Point(-1, -1)
    var width = 0
    var height = 0
    val result = ListBuffer[Result]()
    val A = inputImage.clone

    var i = 0;
    var j = 0
    for (i <- 0 until A.length) {
      for (j <- 0 until A(0).length) {
        if (A(i)(j) == 0) {
          topLeft = Point(i, j)

          var tempJ = j + 1
          width = 1
          while (tempJ < A(0).length && A(i)(tempJ) == 0) {

            width += 1
            tempJ += 1
          }

          var tempI = i + 1
          height = 1
          while (i < A.length && A(tempI)(j) == 0) {

            height += 1
            tempI += 1
          }

          // mark all

          for (tempI <- i until i + height) {
            for (tempJ <- j until j + width) {
              A(tempI)(tempJ) = -1
            }
          }


          result += Result(topLeft, width, height)
        }
      }
    }
    result
  }


}
