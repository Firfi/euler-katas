package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 */
object MaxSlice {
  def solution(a: Array[Int]): Int = {
    var (maxSlice, maxCurrent) = (a.head, a.head)
    for (n <- a.tail) {
      maxCurrent = math.max(n, maxCurrent + n)
      maxSlice = math.max(maxCurrent, maxSlice)
    }
    maxSlice
  }
}
