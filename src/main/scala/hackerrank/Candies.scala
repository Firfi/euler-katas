package hackerrank

object Candies {
  def solve(cldrn: Seq[Int]): Int = {
    cldrn match {
      case Nil => 0
      case children =>
        children.zip(children.tail).foldLeft(List.empty[Int])({case (diffs, (c1, c2)) =>
          (c1 - c2) :: diffs
        }).foldLeft(0->children.length)({case ((deviation, res), diff) =>
          val newDeviation =
            if (deviation >= 0 && diff > 0) 1 + deviation else
            if (deviation <= 0 && diff < 0) -1 + deviation else
            if (diff == 0) 0 else
              0 // jumps like dev < and diff > OR dev > and diff <
          (newDeviation, res + Math.abs(newDeviation))
        })._2
    }
  }
  def solveTest(s: String): Int = {
    solve(s.split("").filter(_ != "").map(_.toInt))
  }
  def brute(cldrn: Seq[Int]): Int = {
    cldrn match {
      case Nil => 0
      case children =>
        val ncandies = children.map(_ => 1).to[collection.mutable.ArrayBuffer]
        var changed = true
        while (changed) {
          changed = false
          children.zip(children.tail).zipWithIndex.foreach({case ((c1, c2), i) =>
            val (ca1, ca2) = (ncandies(i), ncandies(i + 1))
            if (c1 > c2 && ca1 <= ca2) {
              val add = ca2 - ca1 + 1
              ncandies(i) += add
              changed = true
            } else if (c1 < c2 && ca1 >= ca2) {
              val add = ca1 - ca2 + 1
              ncandies(i + 1) += add
              changed = true
            }
          })
        }
        ncandies.sum
    }
  }
  def main(args: Array[String]): Unit = {
    // readInt, readLine ...
  }
}
