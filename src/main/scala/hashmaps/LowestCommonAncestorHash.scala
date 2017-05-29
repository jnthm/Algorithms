package hashmaps

import scala.collection.mutable.Set

case class N1(d: Int, var left: N1 = null, var right: N1 = null) {
  var parent: N1 = _
}

class LowestCommonAncestorHash {

  def LCA(a: N1, b: N1): N1 = {
    val visitedNodes = Set[N1]()
    var currA = a
    var currB = b

    while (currA != null || currB != null) {

      if (currA != null) {
        if (!visitedNodes.add(currA)) {
          return currA
        }
        currA = currA.parent
      }

      if (currB != null) {
        if (!visitedNodes.add(currB)) {
          return currB
        }
        currB = currB.parent
      }
    }
    throw new IllegalArgumentException("nodes a & b are not in the same tree")
  }

}

object LowestCommonAncestorHashTest extends App {

  var root = N1(3, left = N1(2, null, null), null)
  root.left.parent = root
  root.left.left = N1(1, null, null)
  root.left.left.parent = root.left
  root.right = N1(5, null, null)
  root.right.parent = root
  root.right.left = N1(4, null, null)
  root.right.left.parent = root.right
  root.right.right = N1(6, null, null)
  root.right.right.parent = root.right

  val l = new LowestCommonAncestorHash()
  println(l.LCA(root.left, root.right).d)
  println(l.LCA(root.right.left, root.right.right).d)


}
