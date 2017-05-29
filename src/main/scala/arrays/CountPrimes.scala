package arrays

import scala.collection.mutable.ArrayBuffer

object CountPrimes extends App {

  def listPrimes(n: Int): ArrayBuffer[Int] = {
    val primesArr = ArrayBuffer.fill[Boolean](n + 1)(false)
    for (i <- 2 to n if i * i < n) {
      if (!primesArr(i)) {

        var mul = 1
        var prod = i * mul
        while (prod <= n) {
          primesArr(prod) = true
          mul += 1
          prod = i * mul
        }


      }
    }
    primesArr.zipWithIndex.filter(!_._1).map(_._2)
  }

  print(listPrimes(10).mkString(", "))
  println
  print(listPrimes(100).mkString(", "))

}
