package util

object Util {
  def stringToFrequencyMap(s: String): Map[Char, Int] = {
    s.toArray.foldLeft(Map.empty[Char, Int].withDefault((_) => 0))({case (acc, c) =>
      acc.updated(c, acc(c) + 1)
    })
  }
}
