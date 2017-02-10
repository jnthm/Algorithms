package searching

object FindKthElementInTwoSortedArrays {
  /*
  given two sorted arrays, find kth in the union


   */
  def findKthElementInTwoSortedArrays(A: Array[Int], B: Array[Int], k: Int): Int = {

    /*
    1. consider only upto k elements in arr1 and arr2
    2. compare A/2 with B/2
    3. compare
     */
    var startA = 0
    var startB = 0
    var endA = 0
    var endB = 0

    if (A.length > k)
      endA = k - 1
    else
      endA = A.length - 1

    if (B.length > k)
      endB = k - 1
    else
      endB = B.length - 1

    kthSmallestHelper(A, startA, endA, B, startB, endB, k)



    0
  }

  def kthSmallestHelper(A: Array[Int], startA: Int, endA: Int, B:Array[Int], startB:Int, endB:Int, k: Int): Int = {

    var midA = startA + (endA - startA)/2
    var midB = startB + (endB - startB)/2

    if (A(midA) < B(midB)) {

      val aStartsAt = math.min(k/2, midA)
      val bEndsAt = math.min(k/2, midB)

      kthSmallestHelper(A, aStartsAt, endA, B, startB, bEndsAt, k/2: Int)
    } else if (A(midA) == B(midB)) {
      scala.math.min(A(midA), B(midB))
    } else {
      val aEndsAt = math.min(k/2, midA)
      val bStartsAt = math.min(k/2, midB)

      kthSmallestHelper(A, startA, aEndsAt, B, bStartsAt, endB, k/2: Int)
    }
  }


}