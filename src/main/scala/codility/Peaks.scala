package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/16/14
 * Time: 12:06 AM
 * To change this template use File | Settings | File Templates.
 */
object Peaks {
  def solution(a: Array[Int]): Int = {
    import scala.collection.mutable
    val l = a.length
    if (l < 3) 0
    else {
      val peaks = (a, a.tail, a.tail.tail).zipped.toList.zip(Stream.from(1)).filter({
        case ((p, q, r), i) => q > p && q > r
      }).map(_._2) // indices of peaks
      val pl = peaks.length
      if (pl == 0) 0
      else {
        var divisors = mutable.SortedSet(l) // do not count n as we can't have 1 sized blocks
        val sqrt = math.sqrt(l)
        val floor = math.floor(sqrt)
        if (sqrt - floor == 0) divisors += sqrt.toInt
        else if (l % floor == 0) (divisors += floor.toInt) += (l / floor.toInt)
        for (p <- 2.until(floor.toInt)) {
          if (l % p == 0) (divisors += p) += (l / p)
        }
        divisors = divisors.filter(size => l / size <= pl)
        import scala.util.control.Breaks._
        for (size <- divisors) {
          val groups = l / size
          var step = 0
          var ok = true
          breakable { for (p <- peaks) {
            if (p / size > step) {
              ok = false
              break()
            } else if (p / size == step) step += 1
          } }
          if (step != groups) ok = false
          if (ok) return groups
        }
        0
      }
    }
  }
}
