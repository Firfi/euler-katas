package hackerrank

object Anagram {
  def stringToFrequencyMap(s: String): Map[Char, Int] = {
    s.toArray.foldLeft(Map.empty[Char, Int].withDefault((_) => 0))({case (acc, c) =>
      acc.updated(c, acc(c) + 1)
    })
  }
  def solve(ss: (String, String)): Int = {
    // strings of same length
    val fm1 = stringToFrequencyMap(ss._1)
    val fm2 = stringToFrequencyMap(ss._2)
    fm2.toArray.map({case (c2, f2) =>
      val f1 = fm1(c2)
      val diff = f2 - f1
      if (diff < 0) 0 else diff
    }).sum
  }
  def split(s: String): Option[(String, String)] = {
    // it is not 0 by definition
    if (s.length % 2 == 0) Some((s.substring(0, s.length / 2), s.substring(s.length / 2, s.length)))
    else None
  }
  def main(args: Array[String]): Unit = {
    val n = readInt()
    println(1.to(n).map((_) => readLine()).map(split).map((o) => o.map(solve).getOrElse(-1)).mkString("\n"))
  }
}
