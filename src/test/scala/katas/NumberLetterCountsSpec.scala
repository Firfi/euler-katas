package katas

import org.specs2.mutable._

class NumberLetterCountsSpec extends Specification {
  "NumberLetterCounts" should {
    "do the job" in {
      NumberLetterCounts() must_== 21124
    }
  }
}
