package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/11/14
 * Time: 11:47 PM
 * To change this template use File | Settings | File Templates.
 */
import scala.collection.mutable
object FrogRiver {
  def solution(x: Int, a: Array[Int]): Int = {
    if (a.size < x) -1
    else {
      val positions = mutable.BitSet()
      positions.sizeHint(x)
      var size = 0 // size optimization. give us one second so codility is happy
      for ((n, i) <- a.zip(Stream.from(0))) {
        if (!positions(n) && n <= x) {
          positions.add(n)
          size += 1
          if (size == x) return i
        }
      }
      -1
    }
  }
}
