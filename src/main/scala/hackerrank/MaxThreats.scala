package hackerrank

object MaxThreats {
  val steps = List[(Coords) => Coords](
    (mn) => mn.copy(_1 = mn._1 + 1),
    (mn) => mn.copy(_1 = mn._1 + 1, _2 = mn._2 + 1),
    (mn) => mn.copy(_1 = mn._1 + 1, _2 = mn._2 - 1),
    (mn) => mn.copy(_1 = mn._1 - 1),
    (mn) => mn.copy(_1 = mn._1 - 1, _2 = mn._2 + 1),
    (mn) => mn.copy(_1 = mn._1 - 1, _2 = mn._2 - 1),
    (mn) => mn.copy(_2 = mn._2 + 1),
    (mn) => mn.copy(_2 = mn._2 - 1)
  )

  type Coords = (Int, Int)

  case class Matrix[T](value: Map[Coords, T], m: Int, n: Int)

  implicit def rowsToMatrix(rows: Seq[Seq[Int]]): Matrix[Int] = {
    val m = rows.length
    val n = if (m > 0) rows(0).length else 0
    val value = rows.zipWithIndex.foldLeft(Map.empty[Coords, Int])({case (acc, (row, m)) =>
      row.zipWithIndex.foldLeft(acc)({case (matrix, (b, n)) =>
        matrix.updated(m->n, b)
      })
    })
    Matrix(value, m, n)
  }

  def threatsFor(queen: Coords, field: Matrix[Int], queens: Matrix[Boolean]): Int = {
    println(queens.value)
    // fuk it
    val m = field.m
    val n = field.n
    steps.foldLeft(0)({case (threatsNum, step) =>
      var tn = -1 /* first step it would be the same queen */
      var q = queen
      println("queen: " + q)
      while(q._1 < m && q._2 < n && q._1 >= 0 && q._2 >= 0) { // not goes over field
        if (queens.value(q._1, q._2)) {
          tn += 1
          println("tn: " + tn)
        }
        q = step(q)
        println("queen: " + q)
      }
      tn + threatsNum
    })
  }

  def maxThreats(a: Array[Int]): Int = {
    val l = a.length
    val rows = Seq.fill(l)(Seq.fill(l)(0))
    val threatMatrix = rowsToMatrix(rows)
    val queenMatrix = Matrix(a.zipWithIndex.map({case (n, mi) =>
      (mi, n - 1)->true
    }).toMap.withDefaultValue(false), l, l)
    a.zipWithIndex.foldLeft(0)({case (threatsMax, (n, mi)) =>
      val ni = n - 1
      Math.max(threatsFor((mi, ni), threatMatrix, queenMatrix), threatsMax)
    })
  }
}
