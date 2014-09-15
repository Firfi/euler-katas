package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/13/14
 * Time: 2:54 AM
 * To change this template use File | Settings | File Templates.
 */
object Test {
  def solution(a: Array[Int]): Int = {
    def isTriangle(p: Long, q: Long, r: Long): Boolean = p + q > r && q + r > p && r + p > q
    if (a.length < 3) 0
    else {
      val b = a.sorted
      if ((b, b.tail, b.tail.tail).zipped.exists({
        case (p, q, r) => isTriangle(p, q, r)
      })) 1 else 0
    }
  }
}
