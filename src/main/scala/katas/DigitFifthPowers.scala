package katas

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 5/24/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
object DigitFifthPowers {
  def apply(pow: Int) = {
    def sumOfPowers(num: Int): Int = num.toString.map(_.toInt - 48).map(Math.pow(_, pow)).sum.toInt
    val cap = { // function decimalNumber(n) where n is count of digits grows faster than sumOfPowers(decimalNumber(n))
      Stream.from(1).map(n => n->sumOfPowers(List.fill(n)(9).zipWithIndex.foldLeft(0)({
        case (acc, (digit, i)) => (acc + digit * Math.pow(10, i)).toInt
      }))).takeWhile({
        case (n, s) => s.toString.length > n
      }).last._2
    }
    Stream.from(10).takeWhile(_ <= cap).map(n => n->sumOfPowers(n))
      .filter({case (num, sop) => num == sop}).map(_._1).sum
  }
}
