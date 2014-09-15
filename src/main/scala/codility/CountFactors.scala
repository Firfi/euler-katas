package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
object CountFactors {
  def solution(n: Int): Int = {
    val sqrt = math.sqrt(n)
    var res = 0
    if (n % sqrt == 0) res += 1
    else if (n % math.floor(sqrt) == 0) res += 2
    for (p <- 1.until(math.floor(sqrt).toInt)) {
      if (n % p == 0) res += 2
    }
    res
  }
}
