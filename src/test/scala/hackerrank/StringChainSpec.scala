package hackerrank

import org.specs2.mutable.Specification


class StringChainSpec extends Specification {
  "StringChain" should {
    "do the job" in {
      StringChain.longest_chain(Array(
          "a",
          "b",
          "ba",
          "bca",
          "bda",
          "bdca"
      )) must_== 4
    }
    "do the job" in {
      StringChain.longest_chain(Array(
        "a", "aaaaaa",
      "aaa", "aaaa", "aaaaa", "a", "aaaaaa"
      )) must_== 4
    }
  }
}


