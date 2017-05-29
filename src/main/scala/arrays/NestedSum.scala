package arrays

object NestedSum extends App {

  def depthSum(A: List[Any]): Int = {
    helperDepthSum(A, 1, 0)
  }

  private def helperDepthSum(A: List[Any], depth: Int, result: Int): Int = {
    var partialResult = 0
    partialResult = A match {
      case Nil => result
      case (x: Int) :: _ => depth * x.asInstanceOf[Int]
      case (x: List[Any]) :: _ => helperDepthSum(x.asInstanceOf[List[Any]], depth + 1, partialResult)
    }

    if (A.nonEmpty) helperDepthSum(A.tail, depth, result + partialResult) else partialResult
  }


  println(depthSum(List(List(1, 1), 2, List(1, 1))))
  println(depthSum(List(List(1), List(2))))
  println(depthSum(List(2, 2, 3)))

}
