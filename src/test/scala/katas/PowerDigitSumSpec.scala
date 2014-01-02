package katas

import org.specs2.mutable._

class PowerDigitSumSpec extends Specification {

  "PowerDigitSum" should {
    "do the job" in {
      PowerDigitSum() must_== 1366
    }
  }

}
