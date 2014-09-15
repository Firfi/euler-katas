package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/13/14
 * Time: 2:03 AM
 * To change this template use File | Settings | File Templates.
 */
object CountDiv {
  def solution(a: Int, b: Int, k: Int): Int = {
    val nlr = if (a % k == 0) a else k * (a / k + 1)
    val nrl = if (b % k == 0) b else k * (b / k)
    if (nrl < nlr) 0
    else {
      (nrl - nlr) / k + 1
    }
  }
}
