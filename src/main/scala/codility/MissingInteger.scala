package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/12/14
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
object MissingInteger {
  import scala.collection.mutable
  def solution(a: Array[Int]): Int = {
    val aa = a.filter(_ >= 1)
    val counts = mutable.Set[Int](aa: _*)
    if (counts.isEmpty) return 1
    val max = counts.max.toLong
    var min = counts.min.toLong
    val initialMin = min
    if (initialMin > 1) return 1
    while (min != max) {
      min += 1
      if (!counts(min.toInt)) return min.toInt
    }
    min.toInt + 1
  }
}
