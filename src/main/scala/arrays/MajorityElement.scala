package arrays

/**
  * Created by sindhurao on 3/19/17.
  */
object MajorityElement extends App {

  def findMajority(A: Array[Int]): Option[Int] = {
    var count: Int = 0
    var candidate: Int = 0
    for (i <- 0 until A.length) {
      if (count == 0) {
        candidate = A(i)
        count = 1
      } else if (A(i) == candidate) {
        count += 1
      } else {
        count -= 1
      }
    }
    // check if candidate is majority
    if (A.count(_ == candidate) > A.length / 2) Some(candidate)
    else None
  }

  println(findMajority(Array(1, 3, 3, 1, 2)))
  println(findMajority(Array(3, 3, 4, 2, 4, 4, 2, 4, 4)))
  println(findMajority(Array(3, 3, 4, 2, 4, 4, 2, 4)))

}
