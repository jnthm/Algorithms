package hashmaps

import scala.collection.mutable

case class Point(x: Int, y: Int)

case class Rational(numerator: Int, denominator: Int) {
  def getCanonicalForm: Rational = {
    val gcd = BigInt(numerator).gcd(BigInt(denominator)).toInt
    val a = numerator / gcd
    val b = denominator / gcd
    if (b < 0) Rational(-a, -b) else Rational(a, b)
  }
}

case class Line(p1: Point, p2: Point) {
  def slope: Rational = {
    if (p1.x == p2.x)
      Rational(1, 0)
    else
      Rational(p1.y - p2.y, p1.x - p2.x).getCanonicalForm
  }

  def intercept: Rational = {
    if (p1.x == p2.x)
      Rational(p1.x, 0)
    else
      Rational(p2.x * p1.y - p1.x * p2.y, p1.x - p2.x).getCanonicalForm
  }

  override def equals(that: scala.Any): Boolean = {
    that match {
      case that: Line => this.slope.equals(that.slope) && this.intercept.equals(that.intercept)
      case _ => false
    }
  }

  override def hashCode(): Int = {
    (this.slope.hashCode() ^ this.intercept.hashCode()).hashCode
  }
}

class LineMostPoints {

  def getLineWithMostPoints(points: Array[Point]): mutable.Set[Point] = {

    val lineMap = mutable.Map.empty[Line, mutable.Set[Point]]


    for (i <- 0 until points.length) {
      for (j <- i + 1 until points.length) {
        val line = Line(points(i), points(j))
        val setToBeInserted = if (lineMap.get(line).isDefined)
          lineMap(line) += (points(i), points(j))
        else
          mutable.Set(points(i), points(j))
        lineMap += (line -> setToBeInserted)
      }
    }

    lineMap.iterator.max(Ordering.by[(Line, mutable.Set[Point]), Int](_._2.size))._2
  }
}


object LineMostPointsTest extends App {
  val in = Array(
    Point(0, 1), Point(1, 2), Point(2, 4), Point(3, 3),
    Point(0, 0), Point(1, 0), Point(2, 0), Point(3, 0),
    Point(0, -1), Point(1, -2), Point(2, -4), Point(3, -3)
  )
  println(new LineMostPoints().getLineWithMostPoints(in))

}
