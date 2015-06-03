package hackerrank

object BotSavesPrincess {
  type Coords = (Int, Int)
  def solve(field: Seq[Seq[Char]]): Seq[String] = {
    val field_ = field.zipWithIndex.foldLeft(Map.empty[Coords, Char]) { case (f, (row, m)) =>
      row.zipWithIndex.foldLeft(f) { case (f_, (char, n)) =>
        f_.updated((m, n), char)
      }
    }
    field_.find { case (_, t) => t == 'm'}.flatMap({ case (startCoords, _) =>
      field_.find { case (_, t) => t == 'p' }.map({case (finishCoords, _) => (startCoords, finishCoords)})
    }) match {
      case None => Seq.empty
      case Some((start, finish)) =>
        def toSteps(n: Int, vertical: Boolean): Seq[String] = {
          if (n == 0) Seq.empty
          else {
            val absn = Math.abs(n)
            Seq.fill(absn) {
              (absn > 0, vertical) match {
                case (true, true) => "DOWN"
                case (true, false) => "LEFT"
                case (false, true) => "UP"
                case (false, false) => "RIGHT"
              }
            }
          }

        }
        val vertical = toSteps(finish._1 - start._1, vertical=true)
        val horisontal = toSteps(finish._2 - start._2, vertical=false)
        vertical ++ horisontal
    }

  }
  def main(args: Array[String]): Unit = {
    val size = readInt()
    println(solve(1.to(size).map((_) => readLine().split("").filter(_ != "").toSeq.map((s) => s.charAt(0)))).mkString("\n"))
  }
}
