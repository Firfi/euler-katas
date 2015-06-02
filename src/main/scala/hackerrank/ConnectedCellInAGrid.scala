package hackerrank

object ConnectedCellInAGrid {

  type M = Int
  type N = Int
  type Presence = Boolean
  type Matrix = Map[(M, N), Presence]
  type Visited = Set[(M, N)]

  val steps = List[((M, N)) => (M, N)](
    (mn) => mn.copy(_1 = mn._1 + 1),
    (mn) => mn.copy(_1 = mn._1 + 1, _2 = mn._2 + 1),
    (mn) => mn.copy(_1 = mn._1 + 1, _2 = mn._2 - 1),
    (mn) => mn.copy(_1 = mn._1 - 1),
    (mn) => mn.copy(_1 = mn._1 - 1, _2 = mn._2 + 1),
    (mn) => mn.copy(_1 = mn._1 - 1, _2 = mn._2 - 1),
    (mn) => mn.copy(_2 = mn._2 + 1),
    (mn) => mn.copy(_2 = mn._2 - 1)
  )

  def solveForCluster(mn: (M, N), matrix: Matrix, visited: Visited): (Int, Visited) = {
    // presumably mn exists there already
    def _sfc(mn: (M, N), acc: Int, visited: Visited): (Int, Visited) = {
      if (!matrix(mn) || visited.contains(mn)) {
        (acc, visited)
      } else {
        steps.map((s) => s(mn)).foldLeft((acc + 1, visited + mn))({case (acc@(visitedCount, visited_), mn_) =>
          _sfc(mn_, visitedCount, visited_)

        })
      }
    }
    _sfc(mn, 0, visited)
  }

  def solve(matrix: Matrix): Int = {
    matrix.foldLeft((0, Set.empty[(M, N)]))({case (acc@(max, visited), (mn@(m, n), p)) =>
      if (!visited.contains(mn)) {
        val (clusterSize: Int, v: Visited) = solveForCluster(mn, matrix, visited)
        (Math.max(max, clusterSize), v)
      } else {
        acc
      }
    })._1
  }

  implicit def rowsToMatrix(rows: List[List[Boolean]]): Matrix = {
    rows.zipWithIndex.foldLeft(Map.empty[(Int, Int), Boolean])({case (acc, (row, m)) =>
      row.zipWithIndex.foldLeft(acc)({case (matrix, (b, n)) =>
        matrix.updated(m->n, b)
      })
    }).withDefault((_) => false)
  }

  def solveWithPrehandle(rows: List[String]): Int = {
    solve(rows.map(_.split(' ').map(_.toInt == 1).toList).toList)
  }

  def main(args: Array[String]): Unit = {
    val m = readInt()
    val _n = readInt() // don't need it actually
    println(solveWithPrehandle(1.to(m).map((_) => readLine()).toList))
  }

}
