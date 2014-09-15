package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 1:31 AM
 * To change this template use File | Settings | File Templates.
 */
object Brackets {
  def solution(s: String): Int = {
    import scala.collection.mutable
    val open = Map('{'->'}', '['->']', '('->')')
    val closed = open.map(_.swap)
    val stack = mutable.Stack[Char]()
    for (c <- s) {
      if (open.contains(c)) {
        stack.push(c)
      } else if (closed.contains(c)) {
        if (stack.isEmpty) return 0
        val o = stack.pop()
        val expected = closed(c)
        if (o != expected) return 0
      } else {
        // isn't supposed to be here
      }
    }
    if (stack.isEmpty) 1 else 0
  }
}
