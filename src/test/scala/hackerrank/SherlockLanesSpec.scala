package hackerrank

import org.specs2.mutable.Specification


class SherlockLanesSpec extends Specification {
  "SherlockLanes" should {
    "do the job" in {
      SherlockLanes.solve(Array("aba", "bbb")) must_== 2
    }
    "do the job" in {
      SherlockLanes.solve(Array("aba", "xax")) must_== 3
    }
  }
}


