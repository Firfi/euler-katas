package katas

/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */
object SpecialPythagorianTriplet {
  def apply() = {
    val ab = (for {a <- 1 to 1000; b <- 1 to 1000 if a < b} yield ((a, b), 1000000 - 2000*a - 2000*b + 2*a*b)).find(_._2 == 0).get._1
    val a = ab._1
    val b = ab._2
    val c = Math.sqrt(Math.pow(a, 2) + math.pow(b, 2)).toInt
    a * b * c
  }
}
