package linkedlists

case class PostingListNode(elem: Int, var jump: PostingListNode, var next: PostingListNode)

class CopyingPostingsList {

  def copyPostingsList(L: PostingListNode): PostingListNode = {
    if (L == null) return null

    var copyOfL: PostingListNode = _
    var iter = L

    while (iter != null) {
      val currNode = PostingListNode(iter.elem, null, iter.next)
      iter.next = currNode
      iter = iter.next
    }

    iter = L
    while (iter != null) {
      iter.next.jump = iter.jump.next
      iter = iter.next.next
    }

    copyOfL = L.next
    iter = L
    while (iter.next != null) {
      val tmp = iter.next
      iter.next = tmp.next
      iter = tmp
    }
    copyOfL
  }

}
