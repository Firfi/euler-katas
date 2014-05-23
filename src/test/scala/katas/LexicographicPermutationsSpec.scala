package katas

import org.specs2.mutable.Specification

class LexicographicPermutationsSpec extends Specification {
  "LexicographicPermutations" should {
    "do the job" in {
      LexicographicPermutations() must_== "2783915460"
    }
  }
}
