package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/11/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
import scala.collection.mutable
object Prison {
  def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    val cells: Set[Int] = c.toSet
    val points = mutable.Map[Int, Int]()
    a.zip(b).foreach({
      case (l, r) => {
        if (cells.contains(l) && cells.contains(r)) {

        } else if (cells.contains(l)) {
          val value = points.getOrElse(r, 0)
          points.update(r, value + 1)
        } else if (cells.contains(r)) {
          val value = points.getOrElse(l, 0)
          points.update(l, value + 1)
        } else {
          val (lv, rv) = (points.getOrElse(l, 0), points.getOrElse(r, 0))

        }
      }
    })
  }
}
