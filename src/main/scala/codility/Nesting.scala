package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
object Nesting {
  def solution(s: String): Int = {
    var stack = 0
    for (c <- s) {
      if (c == '(') stack += 1
      else stack -= 1
      if (stack < 0) return 0
    }
    if (stack != 0) 0 else 1
  }
}
