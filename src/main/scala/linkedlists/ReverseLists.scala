package linkedlists

case class SingleLinkedListNode(elem: Int, var next: SingleLinkedListNode)

class ReverseLists {

  def reverseList(L: SingleLinkedListNode): SingleLinkedListNode = {
    var currNode = L
    var prev: SingleLinkedListNode = null
    while (currNode != null) {
      val tmp = currNode.next
      currNode.next = prev
      prev = currNode
      currNode = tmp
    }
    prev
  }

}
