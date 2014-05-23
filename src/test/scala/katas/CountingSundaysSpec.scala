package katas

import org.specs2.mutable.Specification

class CountingSundaysSpec extends Specification {
  "CountingSundays" should {
    "do the job" in {
      CountingSundays() must_== 171
    }
  }
}
