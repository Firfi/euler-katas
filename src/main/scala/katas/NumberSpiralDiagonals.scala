package katas

/*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */

object NumberSpiralDiagonals {
  def apply(side: Int) = {
    def cornersForSide(side: Int): Int = 1 + (side-1)*2
    lazy val spiral: Stream[Int] = 1 #:: spiral.zip(Stream.from(0)).map({
      case (prev, n) => prev + (n/4+1)*2
    })
    spiral.take(cornersForSide(side)).sum
  }
}
