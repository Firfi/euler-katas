package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/11/14
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
import scala.collection.mutable
object PermCheck {
  def solution(a: Array[Int]): Int = {
    if (a.max > a.length) 0
    else {
      val counts = mutable.BitSet()
      counts.sizeHint(a.max)
      for (n <- a) {
        if (counts(n)) return 0
        else counts(n) = true
      }
      if (counts.size == counts.last) 1 else 0
    }
  }
}