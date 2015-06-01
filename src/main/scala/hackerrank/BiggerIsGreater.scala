package hackerrank

/**
 * Created by firfi on 5/30/15 AD.
 */
/* 154 -> 415 */
object BiggerIsGreater {
  val NOANSWER = "no answer"
  def solve(s: String): String = {
    if (s.length() < 2) {
      NOANSWER
    } else {
      val ca = s.toCharArray
      val l = ca.length
      var i = l - 2
      while (i >= 0 && ca(i) >= ca(i + 1)) i -= 1
      if (i < 0) NOANSWER
      else {
        var minI = i + 1
        var j = minI + 1
        while (j < l) {
          if (ca(minI) > ca(j) && ca(j) > ca(i)) minI = j
          j += 1
        }
        val cai = ca(i); val caminI = ca(minI)
        ca(minI) = cai; ca(i) = caminI
        (ca.take(i + 1) ++ ca.drop(i + 1).sorted).mkString("")
      }
    }
  }
  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val n = readInt()
    println(1.to(n).map((_) => readLine()).map(solve).mkString("\n"))
  }
}
