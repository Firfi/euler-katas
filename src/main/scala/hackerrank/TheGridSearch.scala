package hackerrank

/**
 * Created by firfi on 6/1/15 AD.
 */
object TheGridSearch { // naive, 40 out of 50
  val YES = "YES"
  val NO = "NO"
  type Coords = (Int, Int)
  case class Matrix(value: Map[Coords, Int], m: Int, n: Int)
  def solve(matrix: Matrix, subMatrix: Matrix): Boolean = {
    matrix.value.exists({case ((m, n), v) =>
      if (v == subMatrix.value(0->0)) {
        m.until(m + subMatrix.m).forall((subm) =>
          n.until(n + subMatrix.n).forall((subn) =>
            matrix.value(subm->subn) == subMatrix.value((subm - m, subn - n))
          )
        )
      } else {
        false
      }
    })
  }
  implicit def rowsToMatrix(rows: Seq[Seq[Int]]): Matrix = {
    val m = rows.length
    val n = if (m > 0) rows(0).length else 0
    val value = rows.zipWithIndex.foldLeft(Map.empty[Coords, Int])({case (acc, (row, m)) =>
      row.zipWithIndex.foldLeft(acc)({case (matrix, (b, n)) =>
        matrix.updated(m->n, b)
      })
    }).withDefault((_) => -1)
    Matrix(value, m, n)
  }
  def main(args: Array[String]): Unit = {
    val t = readInt()
    def readArray(): Seq[Seq[Int]] = {
      val Array(m, n) = readLine().split(" ").map(_.toInt)
      1.to(m).map((_) => {
        readLine().split("").filter(_ != ""/*well there's garbage in input*/).map(_.toInt).toSeq
      })
    }
    println(1.to(t).map((_) => {
      val a = readArray()
      val b = readArray()
      solve(a, b)
    }).map((b) => if (b) YES else NO).mkString("\n"))

  }
}
