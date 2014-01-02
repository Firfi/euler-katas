package katas

import scala.collection.mutable

/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/

object SummationOfPrimes {
  def sieveOfEratosthenes(nTo: Int) = {
    val primes = collection.mutable.BitSet.empty.par ++ (2 to nTo)
    for {
      candidate <- 2 until Math.sqrt(nTo).toInt
      if primes contains candidate
    } primes --= candidate * candidate to nTo by candidate
    primes
  }
  def apply() = {
    sieveOfEratosthenes(2000000 - 1).map(_.toLong).sum
  }
}
