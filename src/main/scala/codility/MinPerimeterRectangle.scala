package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/15/14
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
object MinPerimeterRectangle {
  def solution(n: Int): Int = {
//    var minPer = (1 + n) * 2
//    for (k <- 1.to(n)) {
//      if (n % k == 0) {
//        minPer = math.min(minPer, (k + (n / k)) * 2)
//      }
//    }
//    println(minPer)
    if (math.sqrt(n) == math.floor(math.sqrt(n))) math.sqrt(n).toInt * 4
    else {
      // find nearest int?
      for (k <- math.sqrt(n).toInt.to(1).by(-1)) {
        if (n % k == 0) {
          val a = k
          val b = n / k
          return (a + b) * 2
        }
      }
      (1 + n) * 2
    }
  }
}
