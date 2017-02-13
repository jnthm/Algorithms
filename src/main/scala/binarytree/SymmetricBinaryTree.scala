package binarytree


class SymmetricBinaryTree {

  def checkSymm(node: Node[Int]): Boolean = {
    node == null || isItSymm(node.left, node.right)
  }

  def isItSymm(l: Node[Int], r: Node[Int]): Boolean = {
    if (l == null && r == null)
      true
    else if (l != null && r != null)
      (l.elem == r.elem) && isItSymm(l.left, r.right) && isItSymm(l.right, r.left)
    else
      false
  }

}
