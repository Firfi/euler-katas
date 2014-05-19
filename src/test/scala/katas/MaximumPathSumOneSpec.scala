package katas

import org.specs2.mutable.Specification

class MaximumPathSumOneSpec extends Specification {
  "MaximumPathSumOne" should {
    "do the job" in {
      MaximumPathSumOne() must_== 1074
    }
  }
}
