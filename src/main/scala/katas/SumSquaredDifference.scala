package katas

/*
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
object SumSquaredDifference {
  def apply() = {
    val s1 = (1L to 100L).reduceLeft((a, b) => a + Math.pow(b, 2).toLong)
    val s2 = Math.pow((1L to 100L).sum, 2).toLong
    s2 - s1
  }
}
