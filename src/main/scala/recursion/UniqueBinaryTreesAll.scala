package recursion

import scala.collection.mutable.ListBuffer

class UniqueBinaryTreesAll {

  case class Node(elem: Int, var left: Node, var right: Node)

  def generateAllBinaryTrees(numNodes: Int): ListBuffer[Node] = {
    val result = ListBuffer[Node]()
    if (numNodes <= 0) {
      return result
    }
    for (i <- 0 to numNodes) {
      val leftTrees = generateAllBinaryTrees(numNodes - i - 1)
      val rightTrees = generateAllBinaryTrees(i)

      for (l <- 0 until leftTrees.length) {
        for (r <- 0 until rightTrees.length) {
          result += Node(-1, leftTrees(l), rightTrees(r))
        }
      }
    }
    result
  }

}
