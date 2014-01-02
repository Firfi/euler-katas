package katas

import org.specs2.mutable.Specification

class StPrimeSpec extends Specification {
  "StPrime" should {
    "do the job" in {
      StPrime() must_== 233168
    }
  }
}
