package binarytree

/**
  * Created by sindhurao on 3/19/17.
  */
object PopulatingNextRightPointers {

  case class Node(data: Int, var left: Option[Node] = None, var right: Option[Node] = None, var next: Option[Node])

  def constructRightSibling(root: Node): Unit = {
    var curr = Option(root)
    while (curr.isDefined) {
      populateNextPointers(curr.get)
      curr = curr.get.left
    }
  }

  private def populateNextPointers(root: Node): Unit = {
    var iter = Option(root)

    while (iter.isDefined) {
      iter.get.left.get.next = iter.get.right

      if (iter.get.next.isDefined) {
        iter.get.right.get.next = iter.get.next.get.left
        iter = iter.get.next
      }
      iter = iter.get.next
    }


  }

}
