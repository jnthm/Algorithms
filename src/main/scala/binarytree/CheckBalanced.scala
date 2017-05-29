package binarytree

case class Node[T](elem: T, left: Node[T], right: Node[T])

case class NodeWithHeight(isBalanced: Boolean, height: Int)

class CheckBalanced {
  def checkBalanced(node: Node[Int]): Boolean = checkBalancedHelper(node).isBalanced

  private def checkBalancedHelper(node: Node[Int]): NodeWithHeight = {
    if (node == null)
      NodeWithHeight(isBalanced = true, 0)
    else {
      val ln = checkBalancedHelper(node.left)
      val rn = checkBalancedHelper(node.right)
      NodeWithHeight(math.abs(ln.height - rn.height) <= 1 && ln.isBalanced && rn.isBalanced,
        math.max(ln.height, rn.height) + 1)
    }
  }
}
