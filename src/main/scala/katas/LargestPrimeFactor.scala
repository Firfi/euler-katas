package katas

import scala.annotation.tailrec

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */
object LargestPrimeFactor {
  def apply() = {
    val n = 600851475143L
    def lpfPart(l: Long): Long = {
      var m = 2L
      var res = 0L
      while (m < l) {
        if (l % m == 0) { res = m; m = l }
        else m = m + 1
      }
      if (res == 0L) l
      else lpfPart(l / res)
    }
    lpfPart(n)
  }
}
