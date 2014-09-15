package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
object MaxProfit {
  def solution(a: Array[Int]): Int = {
    if (a.length < 2) 0
    else {
      val diffs = a.zip(a.tail).map({case (n1, n2) => n2 - n1})
      var (maxPos, maxSlice) = (0, 0)
      for (n <- diffs) {
        maxPos = math.max(0, maxPos + n)
        maxSlice = math.max(maxPos, maxSlice)
      }
      maxSlice
    }
  }
}
