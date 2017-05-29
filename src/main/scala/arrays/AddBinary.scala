package arrays

/**
  * Created by sindhurao on 3/19/17.
  */
object AddBinary extends App {
  def addBinary(a: String, b: String): String = {
    val result = new StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var carry = 0
    var sum = 0
    while (i >= 0 || j >= 0) {
      val s1 = if (i >= 0) {
        a.charAt(i) - '0'
      } else 0
      val s2 = if (j >= 0) {
        b.charAt(j) - '0'
      } else 0
      sum = s1 ^ s2 ^ carry
      carry = s1 * s2 | s1 * carry | s2 * carry
      result.append(sum)

      if (i >= 0) i -= 1
      if (j >= 0) j -= 1
    }

    if (carry > 0) result.append(carry)
    result.reverse.toString()
  }

  println(addBinary("1100011", "10"))

}
