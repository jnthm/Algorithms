package graphs

object NumIslands extends App {

  def numIslands(grid: Array[Array[Char]]): Int = {
    val tempGrid = grid.clone()
    var islandCount = 0

    val r = tempGrid.length
    val c = tempGrid(0).length

    for (i <- 0 until r) {
      for (j <- 0 until c) {
        if (tempGrid(i)(j) == '1') {
          dfs(tempGrid, i, j)
          println(tempGrid.deep.mkString("\n"))
          islandCount += 1
        }
      }
    }

    islandCount
  }

  private def dfs(grid: Array[Array[Char]], i: Int, j: Int): Unit = {

    if (i < 0 || i >= grid.length || j < 0 || j >= grid(0).length || grid(i)(j) == '0')
      return

    grid(i)(j) = '0'
    dfs(grid, i - 1, j)
    dfs(grid, i, j + 1)
    dfs(grid, i + 1, j)
    dfs(grid, i, j - 1)


  }

  val in1 = Array(Array('1', '1', '1', '1', '0'), Array('1', '1', '0', '1', '0'), Array('1', '1', '0', '0', '0'), Array('0', '0', '0', '0', '0'))
  val in2 = Array(Array('1', '1', '0', '0', '0'), Array('1', '1', '0', '0', '0'), Array('0', '0', '1', '0', '0'), Array('0', '0', '0', '1', '1'))


  println(numIslands(in1))
  println(numIslands(in2))

}
