package katas

import org.specs2.mutable.Specification

class LargestPalindromeProductSpec extends Specification {
  "LargestPalindromeProduct" should {
    "do the job" in {
      LargestPalindromeProduct() must_== 906609
    }
  }
}
