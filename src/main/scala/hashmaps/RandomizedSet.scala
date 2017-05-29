package hashmaps

import scala.collection.mutable.{ArrayBuffer, Map}

class RandomizedSet {

  val elementMap = Map[Int, Int]()
  val arrayElements = ArrayBuffer[Int]()

  def insert(elem: Int): Boolean = {
    if (!elementMap.contains(elem)) {
      elementMap += (elem -> elementMap.size)
      arrayElements += elem
      true
    } else false
  }

  def remove(elem: Int): Boolean = {
    def swap(from: Int, to: Int, A: ArrayBuffer[Int]): Unit = {
      val temp = A(from)
      A(from) = A(to)
      A(to) = temp
    }

    if (elementMap.contains(elem)) {
      val indexToBeRemoved = elementMap(elem)
      swap(indexToBeRemoved, arrayElements.length - 1, arrayElements)
      arrayElements.remove(arrayElements.length - 1)
      elementMap -= elem
      true
    } else false
  }

  def getRandom(): Int = {
    arrayElements(scala.util.Random.nextInt(arrayElements.length))
  }

}
