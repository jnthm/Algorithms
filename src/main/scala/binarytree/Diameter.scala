package binarytree

object Diameter extends App {

  case class Node(data: Int, left: Option[Node] = None, right: Option[Node] = None)


  /**
    * diameter = Max(leftDiameter, rightDiameter, leftHeight + rightHeight + 1)
    */
  def diameter(root: Option[Node]): Int = {
    diameterHelper(root, 0)._2
  }

  // returnValue (height, diameter)
  private def diameterHelper(root: Option[Node], height: Int): (Int, Int) = {
    if (root.isEmpty)
      (0, 0)
    else if (root.get.left.isEmpty && root.get.right.isEmpty)
      (1, 0)
    else {
      val (lH, lD) = diameterHelper(root.get.left, height)
      val (rH, rD) = diameterHelper(root.get.right, height)

      (math.max(lH, rH) + 1, math.max(math.max(lD, rD), lH + rH + 1))
    }
  }


  val root = Node(1, Some(Node(2, Some(Node(4)), Some(Node(5)))), Some(Node(3)))
  println(diameter(Some(root)))

}
