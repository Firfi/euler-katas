package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 4:44 AM
 * To change this template use File | Settings | File Templates.
 */
object VoraciousFishes {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    import scala.collection.mutable
    val stack = mutable.Stack[Int]() // sizes of fishes swimming downstream
    var alive = 0
    for ((s, d) <- a.zip(b)) {
      if (d == 0) {
        if (stack.isEmpty) alive += 1
        else {
          while (!stack.isEmpty && stack.head < s) {
            stack.pop()
          }
          if (stack.isEmpty) alive += 1
        }
      } else {
        stack.push(s)
      }
    }
    alive + stack.size
  }
}
