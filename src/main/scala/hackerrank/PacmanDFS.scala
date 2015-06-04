package hackerrank

// it doesn't work really well on anything except testing example

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

  def solve(matrix: Matrix, start: Coords, end: Coords): (Int, Seq[Coords], Int, Seq[Coords]) = {
    val stack = collection.mutable.Stack(start->List(start))
    val log = collection.mutable.MutableList.empty[Coords]
    val visited = collection.mutable.HashSet.empty[Coords]
    var done = false
    while (stack.nonEmpty && !done) {
      val (current, path) = stack.pop()
      if (!visited.contains(current)) {
        visited += current
        log += current
        if (current == end) {
          stack.push((current, path)) // keep path
          done = true
        } else {
          val nexts = steps.map((s) => {
            s(current)
          }).filter((coords) => matrix.value(coords) != '%').filter(_._1 < matrix.m).filter(_._2 < matrix.n)
          nexts.foreach((next) => {
            stack.push((next, next :: path))
          })
        }
      }
    }
    (visited.size, log, stack.head._2.length - 1, stack.head._2.reverse)
  }

  def main(args: Array[String]): Unit = {
    val Array(start1, start2) = readLine().split(" ").map(_.toInt)
    val Array(end1, end2) = readLine().split(" ").map(_.toInt)
    val Array(m, n) = readLine().split(" ").map(_.toInt)
    val field = 1.to(m).map((_) =>
      readLine().toSeq
    )
    val (total, log, pathLen, path) = solve(field, start1->start2, end1->end2) //TODO
    println(total)
    log.map((t) => s"${t._1} ${t._2}").foreach(println)
    println(pathLen)
    path.map((t) => s"${t._1} ${t._2}").foreach(println)
  }
}
