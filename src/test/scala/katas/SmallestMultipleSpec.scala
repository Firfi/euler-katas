package katas

import org.specs2.mutable._

class SmallestMultipleSpec extends Specification {
  "SmallestMultiple" should {
    "do the job" in {
      SmallestMultiple() must_== 232792560
    }
  }
}
