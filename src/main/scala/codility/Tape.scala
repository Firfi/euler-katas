package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/11/14
 * Time: 12:49 AM
 * To change this template use File | Settings | File Templates.
 */
object Tape {
  def solution(a: Array[Int]): Int = {
    val leftSum = a(0)
    val rightSum = a.drop(1).sum
    def diff(x: Int, y: Int): Double = Math.abs(x - y)
    a.drop(1).dropRight(1).foldLeft((leftSum, rightSum, diff(rightSum, leftSum)))({
      case ((ls, rs, d), n) => {
        val (nls, nrs) = (ls + n, rs - n)
        (nls, nrs, Math.min(diff(nls, nrs), d))
      }
    })._3.toInt
  }
}
