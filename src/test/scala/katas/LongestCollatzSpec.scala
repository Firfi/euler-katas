package katas

import org.specs2.mutable._

class LongestCollatzSpec extends Specification {
  "LongestCollatz" should {
    "do the job" in {
      LongestCollatz() must_== 233168
    }
  }
}
