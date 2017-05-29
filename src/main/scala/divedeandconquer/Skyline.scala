//package divedeandconquer
//
//import scala.collection.mutable
//import scala.collection.mutable.ListBuffer
//
//
//object Skyline extends App {
//
//  case class InputPoint(left: Int, right: Int, hi: Int)
//
//  case class InterPoint(left: Int, right: Int, isStart: Boolean) extends Ordered[InterPoint] {
//    override def compare(that: InterPoint): Int = {
//      if (this.left != that.left) this.left.compare(that.left)
//      else {
//        if (this.isStart && that.isStart)
//          that.right.compare(this.right)
//        else if (!this.isStart && !that.isStart)
//          this.right.compare(that.right)
//        else
//          that.right.compare(this.right)
//      }
//    }
//  }
//
//  case class OutputPoint(left: Int, right: Int)
//
//  def skyline(A: ListBuffer[InputPoint]): ListBuffer[OutputPoint] = {
//    val result = ListBuffer[OutputPoint]()
//
//    val interPoints = A.flatMap(p => ListBuffer(InterPoint(p.left, p.hi, isStart = true), InterPoint(p.right, p.hi, isStart = false))).sorted
//
//    // TODO: ordering
//    val pq = mutable.TreeMap[Int, Int]()(Ordering[Int, Int].reverse)
//
//    interPoints.foreach {
//      p =>
//        if (p.isStart) {
//          pq.put(p.right, pq.getOrElse(p.right, 0) + 1)
//        } else {
//          pq.put(p.right, pq(p.right) - 1)
//          if (pq(p.right) == 0)
//            pq.remove(p.right)
//        }
//        if (pq.lastKey != pq.max._1) {
//          result += OutputPoint(p.left, p.right)
//        }
//    }
//
//
//  }
//
//
//}
