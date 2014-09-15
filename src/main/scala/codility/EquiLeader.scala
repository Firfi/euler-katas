package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
object EquiLeader {
  def solution(a: Array[Int]): Int = {
    import scala.collection.mutable
    val stack = mutable.Stack[Int]()
    for (n <- a) {
      if (stack.isEmpty) {
        stack.push(n)
      } else {
        val h = stack.head
        if (h != n) {
          stack.pop()
        } else {
          stack.push(n)
        }
      }
    }
    if (stack.isEmpty) 0
    else {
      val leader = stack.head
      val _l = a.filter(_ == leader).length
      var (leadersLeft, othersLeft) = (0, 0)
      var (leadersRight, othersRight) = (_l, a.length - _l)
      var c = 0
      for (n <- a) {
        if (n == leader) {
          leadersLeft += 1
          leadersRight -= 1
        } else {
          othersLeft += 1
          othersRight -= 1
        }
        if (leadersLeft > othersLeft && leadersRight > othersRight) c += 1
      }
      c
    }
  }
}
