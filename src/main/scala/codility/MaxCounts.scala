package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/12/14
 * Time: 6:05 PM
 * To change this template use File | Settings | File Templates.
 */
object MaxCounts {
  import scala.collection.mutable
  def solution(n: Int, ops: Array[Int]): Array[Int] = {
    val counters = mutable.ArrayBuffer.fill(n)(0)
    var max = 0
    var min = 0
    for (op <- ops) {
      if (op <= n || op > 0) {
        val i = op - 1
        var v = counters(i)
        if (v < min) v = min
        v += 1
        if (v > max) max = v
        counters(i) = v
      } else if (op == n + 1) {
        min = max
      } else {} // else fuck you
    }
    counters.map(c => if (c < min) min else c).toArray
  }
}
