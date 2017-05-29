package recursion

import scala.collection.mutable.Stack

class TowerHanoi {

  def computeTowerHanoi(numRings: Int): Unit = {
    val peg1 = Stack[Int]()
    (numRings to 1).foreach(peg1.push)
    val peg2 = Stack[Int]()
    val peg3 = Stack[Int]()

    helper(numRings, peg1, peg2, peg3)
  }

  private def helper(numRings: Int, from: Stack[Int], to: Stack[Int], via: Stack[Int]): Unit = {
    if (numRings > 0) {
      helper(numRings - 1, from, via, to)
      to.push(from.pop)
      helper(numRings - 1, via, to, from)
    }
  }

}
