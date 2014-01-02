package katas

import org.specs2.mutable.Specification

class LargestPrimeFactorSpec extends Specification {
  "LargestPrimeFactor" should {
    "do the job" in {
      LargestPrimeFactor() must_== 6857L
    }
  }
}
