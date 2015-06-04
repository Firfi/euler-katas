package hackerrank

object JimAndTheSkyscrapers {
  def solve(heights: Seq[Long]): BigInt = {
    def countPit(pit: List[Long]): BigInt = {
      pit match {
        case Nil => 0
        case head :: tail =>
          tail.foldLeft(List(List(head)))((lines, h) => {
            val current = lines.head.head
            if (h == current) (h :: lines.head) :: lines.tail
            else List(h) :: lines
          }).filter(_.length > 1).map((l) => {val n = l.length - 1; BigInt(n) * (n + 1)}).sum
      }
    }
    // brute - 5/14 tests
//    var r = 0
//    heights.zipWithIndex.foreach({case (h1, i1) =>
//      heights.drop(i1 + 1).find({case (h2) =>
//        if (h2 > h1) true
//        else {
//          if (h1 == h2) {
//            r += 2
//          }
//          false
//        }
//      })
//    })
//    r
    if (heights.isEmpty) 0
    else {
      val (leftover, pits) = heights.tail.foldLeft((List(heights.head), List(List.empty[Long])))({case (acc@(stash, ps), h) =>
        if (h > stash.head) {
          val (pit, newStash) = stash.span(_ < h)
          (h :: newStash, pit :: ps)
        } else {
          (h :: stash, ps)
        }
      })
      (leftover :: pits).map(countPit).sum
    }

  }
  def main(args: Array[String]): Unit = {
    val _ = readInt()
    val heights = readLine().split(" ").filter(_ != "").map(_.toLong).toSeq
    println(solve(heights))
  }
}
