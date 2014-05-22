package katas

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */

object AmicableNumbers {
  def apply() = {
    def pdsum(n: Long): Long = 1L.to(n/2).filter(d => n % d == 0).sum
    val nums = 2L.until(10000L)
    val pdsums = nums.map(pdsum)
    val reversedPdsums = pdsums.map(pdsum)
    (nums,pdsums,reversedPdsums).zipped.toList.filter({case (n, s, r) => n == r && n != s}).map(_._2).sum
  }
}
