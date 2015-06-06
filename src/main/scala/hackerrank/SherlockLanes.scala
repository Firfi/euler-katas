package hackerrank

object SherlockLanes {
  val modulo: BigInt = BigDecimal(Math.pow(10, 9) + 7).toBigInt()
  type Coords = (Int, Int)

  case class Matrix[T](value: Map[Coords, T], m: Int, n: Int)

  implicit def rowsToMatrix(rows: Seq[Seq[Char]]): Matrix[Char] = {
    val m = rows.length
    val n = if (m > 0) rows(0).length else 0
    val value = rows.zipWithIndex.foldLeft(Map.empty[Coords, Char])({case (acc, (row, m)) =>
      row.zipWithIndex.foldLeft(acc)({case (matrix, (b, n)) =>
        matrix.updated(m->n, b)
      })
    })
    Matrix(value, m, n)
  }
  def solve(ss: Seq[String]): BigInt = {
    val field = rowsToMatrix(ss.map(_.toSeq))
    val coordsCache = field.value.foldLeft(Map.empty[Char, List[Coords]].withDefaultValue(List.empty[Coords]))({case (acc, (coord, c)) =>
      acc.updated(c, coord :: acc(c))
    })
    def solveFor(coord: Coords, total: BigInt = 0): BigInt = {
      if (coord == (0, field.n - 1)) total
      else {
        val steps = (if (coord._2 + 1 >= field.n) Seq.empty[Coords] else Seq(coord.copy(_2 = coord._2 + 1))) ++
          coordsCache(field.value(coord)).filter({case (c1, c2) =>
            c2 > coord._2 // step right on same char
          })
        steps.map((s) => solveFor(s, (total + 1) % modulo)).length % modulo
      }
    }
    solveFor(0->0)
  }
  def main(args: Array[String]): Unit = {
    val Array(n, m) = readLine().split(" ").filter(_ != "").map(_.toInt)
    println(solve(1.to(m).map((_) => readLine())))
  }
}
