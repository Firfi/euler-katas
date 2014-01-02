package katas

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

object StPrime {
  def apply() = {
    var primes = List(2, 3, 5, 7, 11, 13).reverse
    while (primes.length < 10001) {
      primes = Stream.from(primes.head).find({
        n => !primes.exists(n % _ == 0)
      }).get :: primes
    }
    primes.head
  }
}
