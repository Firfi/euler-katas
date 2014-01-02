package katas

import org.specs2.mutable.Specification

class HighlyDivisibleTriangularSpec extends Specification {
  "HighlyDivisibleTriangular" should {
    "do the job" in {
      HighlyDivisibleTriangular() must_== 233168
    }
  }
}
