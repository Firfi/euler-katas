package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 1:57 AM
 * To change this template use File | Settings | File Templates.
 */
object StoneWall {
  def solution(hs: Array[Int]): Int = {
    import scala.collection.mutable
    val stack = mutable.Stack[Int]()
    var n = 0
    for (h <- hs) {
      while (!stack.isEmpty && stack.head > h) {
        stack.pop()
      }
      if (!stack.isEmpty && stack.head == h) {}
      else {
        n += 1
        stack.push(h)
      }
    }
    n
  }
}
