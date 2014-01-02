package katas

import org.specs2.mutable.Specification

class LargestProductGridSpec extends Specification {
  "LargestProductGrid" should {
    "do the job" in {
      LargestProductGrid() must_== 233168
    }
  }
}
