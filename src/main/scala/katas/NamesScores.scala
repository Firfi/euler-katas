package katas

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */

object NamesScores {
  def apply() = {
    def alphavalue(s: String): Long = s.map(_.toInt - 64).sum // or 96 for lowercase
    import scala.io.Source
    Source.fromFile("./data/names.txt").getLines().take(1).toList.head.split(",")
      .map(_.substring(1).dropRight(1)).sorted.zipWithIndex
      .map({case (name, i) => (i + 1) * alphavalue(name)}).sum
  }
}
