package katas

import org.specs2.mutable.Specification

class SpecialPythagorianTripletSpec extends Specification {
  "SpecialPythagorianTriplet" should {
    "do the job" in {
      SpecialPythagorianTriplet() must_== 32625000
    }
  }
}
