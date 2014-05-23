package katas

import org.specs2.mutable.Specification

class SelfPowersSpec extends Specification {
  "SelfPowers" should {
    "do the job" in {
      SelfPowers() must_== 9110846700L
    }
  }
}
