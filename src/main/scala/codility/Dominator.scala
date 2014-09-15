package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 5:43 AM
 * To change this template use File | Settings | File Templates.
 */
object Dominator {
  def solution(a: Array[Int]): Int = {
    import scala.collection.mutable
    val stack = mutable.Stack[Int]()
    for ((n, i) <- a.zipWithIndex) {
      if (stack.isEmpty) {
        stack.push(n)
      } else {
        val last = stack.head
        if (last != n) {
          stack.pop()
          if (stack.isEmpty) {
          }
        } else {
          stack.push(n)
        }
      }
    }
    if (stack.isEmpty) -1
    else {
      val half = a.length / 2
      val dominator = stack.head
      val l = a.filter(_ == dominator).length
      if (l > half) a.indexOf(dominator)
      else -1
    }
  }
}
