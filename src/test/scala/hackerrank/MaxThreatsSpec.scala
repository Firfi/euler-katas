package hackerrank

import org.specs2.mutable.Specification


class MaxThreatsSpec extends Specification {
  "MaxThreats" should {
    "do the job" in {
      MaxThreats.maxThreats(Array(1, 2, 3)) must_== 2
    }
    "do the job" in {
      MaxThreats.maxThreats(Array(
      4,
      5,
      1,
      3,
      7,
      8,
      2,
      6
      )) must_== 2
    }
  }
}


