package katas

import org.specs2.mutable.Specification

class AmicableNumbersSpec extends Specification {
  "AmicableNumbers" should {
    "do the job" in {
      AmicableNumbers() must_== 31626L
    }
  }
}
