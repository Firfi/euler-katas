package katas

import org.specs2.mutable.Specification

class EvenFibonacciSpec extends Specification {
  "EvenFibonacci" should {
    "do the job" in {
      EvenFibonacci() must_== 233168
    }
  }
}
