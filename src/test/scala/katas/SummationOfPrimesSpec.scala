package katas

import org.specs2.mutable._

class SummationOfPrimesSpec extends Specification {

  "SummationOfPrimes" should {
    "do the job" in {
      SummationOfPrimes() must_== 142913828922L
    }
  }

}
