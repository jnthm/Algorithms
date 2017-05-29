package graphs

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue

case class Node(elem: Int, var isVisited: Boolean, edges: ListBuffer[Node])

class BfsTraversal {

  def getNodes(root: Option[Node]): ListBuffer[Node] = {
    val resultBuffer = ListBuffer[Node]()
    if (root.isEmpty)
      resultBuffer
    else {
      val qNodes = Queue[Node]()
      val resultBuffer = ListBuffer[Node]()

      qNodes += root.get

      while (qNodes.nonEmpty) {
        val currNode = qNodes.dequeue
        resultBuffer += currNode
        currNode.isVisited = true
        currNode.edges.foreach { e => if (!e.isVisited) qNodes += e}
      }
      resultBuffer
    }

  }

}
