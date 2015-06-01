package hackerrank

/**
 * Created by firfi on 6/1/15 AD.
 */
object TwoStrings {
  val YES = "YES"
  val NO = "NO"
  def solve(a: String, b: String): String = {
    val as = a.toSet
    val bs = b.toSet
    as.find(bs.contains) match {
      case Some(_) => YES
      case None => NO
    }
  }
  def main(args: Array[String]): Unit = {
    val n = readInt()
    println(1.to(n).map((_) => (readLine(), readLine())).map({case (a, b) => solve(a, b)}).mkString("\n"))
  }
}
