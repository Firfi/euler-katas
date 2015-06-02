package hackerrank

import org.specs2.mutable.Specification

/**
 * Created by firfi on 5/31/15 AD.
 */
class FindMaximumIndexProductSpec extends Specification {
  "FindMaximumIndexProduct" should {
    "do the job" in {
      FindMaximumIndexProduct.solve(Array(1, 2, 1, 4, 2, 5)) must_== 24
    }
    "do the job with sorted array" in {
      FindMaximumIndexProduct.solve(Array(1, 2, 3)) must_== 0
    }
    "do the job with reversed sorted array" in {
      FindMaximumIndexProduct.solve(Array(5, 4, 3, 2, 1)) must_== 0
    }
    "do the job with hackerrank example" in {
      FindMaximumIndexProduct.solve(Array(5, 4, 3, 4, 5)) must_== 8
    }
  }
}


