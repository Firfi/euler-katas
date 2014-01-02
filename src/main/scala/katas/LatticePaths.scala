package katas

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 1/2/14
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
object LatticePaths {
  def apply() {
    val POWERS = 21 // 21 dots and 20 sides
    lazy val s: Stream[List[BigInt]] = List.fill(POWERS)(BigInt(1)) #:: s.map {
      l => l.tail.foldLeft(List(BigInt(1)))({
        case (a, n) => (a.head + n) :: a
      }).reverse
    }
    println(s.take(POWERS).last.last)
  }
}
