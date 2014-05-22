package katas

import org.specs2.mutable.Specification

class NamesScoresSpec extends Specification {
  "NamesScores" should {
    "do the job" in {
      NamesScores() must_== 871198282L
    }
  }
}
