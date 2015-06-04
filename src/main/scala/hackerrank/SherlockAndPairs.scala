package hackerrank

// no really reason for bigints. just because I can

object SherlockAndPairs {
  def solve(a: Seq[BigInt]): BigInt = {
    if (a.length < 2) 0
    else {
      val a_ = a.sorted
      val (_, leftover, res) = a_.tail.foldLeft((a_.head, BigInt(1), BigInt(0)))({case ((current, count, pairs), n) =>
        if (current == n) (current, count + 1, pairs)
        else {
          (n, 1, pairs + ((count - 1) * count))
        }
      })
      res + ((leftover - 1) * leftover)
    }

  }
  def main(args: Array[String]): Unit = {
    val cases = readInt()
    1.to(cases).map((_) => {
      val n = readInt()
      val a = readLine().split(" ").filter(_ != "").map(_.toInt).map((t) => BigInt(t)).toSeq
      println(solve(a))
    })
  }
}
