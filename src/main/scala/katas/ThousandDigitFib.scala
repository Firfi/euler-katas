package katas

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 1/2/14
 * Time: 7:11 PM
 * To change this template use File | Settings | File Templates.
 */
object ThousandDigitFib {
  def apply() = {
    lazy val fibs: Stream[BigInt] = BigInt(1) #:: fibs.scanLeft(BigInt(1))(_ + _)
    def d(n: BigInt) = {n.toString.length}
    fibs.zipWithIndex.find(n=>d(n._1) == 1000).get._2 + 1
  }
}
