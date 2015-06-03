package hackerrank



object PacmanDFS {

  val steps = Seq[(Coords) => (Coords)]( // order from task definition
    (mn) => mn.copy(_1 = mn._1 - 1), // UP
    (mn) => mn.copy(_2 = mn._2 - 1), // LEFT
    (mn) => mn.copy(_2 = mn._2 + 1), // RIGHT
    (mn) => mn.copy(_1 = mn._1 + 1) // DOWN
  )

  type Coords = (Int, Int)

  case class Matrix(value: Map[Coords, Char], m: Int, n: Int)

  implicit def rowsToMatrix(rows: Seq[Seq[Char]]): Matrix = {
    val m = rows.length
    val n = if (m > 0) rows(0).length else 0
    val value = rows.zipWithIndex.foldLeft(Map.empty[Coords, Char])({case (acc, (row, m)) =>
      row.zipWithIndex.foldLeft(acc)({case (matrix, (b, n)) =>
        matrix.updated(m->n, b)
      })
    })
    Matrix(value, m, n)
  }

  def solve(matrix: Matrix, start: Coords, end: Coords): Int = {
    val stack = collection.mutable.Stack(start)
    val log = collection.mutable.MutableList.empty[Coords]
    var visitedCount = 1 // premature (or not) optimisation, who knows. it helper on codility.
    val visited = collection.mutable.HashSet.empty[Coords]
    while (stack.nonEmpty) {
      val current = stack.pop()
      if (!visited.contains(current)) {
        visited += current
        visitedCount += 1
        log += current
        if (current == end) {
          stack.clear() // no search anymore
        } else {
          steps.map((s) => {
            s(current)
          }).filter(_ != '%').filter(_._1 < matrix.m).filter(_._2 < matrix.n).foreach((next) => {
            stack.push(next)
          })
        }
      }
    }
    ??? // TODO
  }

  def main(args: Array[String]): Unit = {
    val Array(start1, start2) = readLine().split(" ").map(_.toInt)
    val Array(end1, end2) = readLine().split(" ").map(_.toInt)
    val Array(m, n) = readLine().split(" ").map(_.toInt)
    val field = 1.to(m).map((_) =>
      readLine().toSeq
    )
    solve(field, start1->start2, end1->end2) //TODO
  }
}
