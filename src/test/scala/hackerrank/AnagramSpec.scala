package hackerrank

import org.specs2.mutable.Specification


class AnagramSpec extends Specification {
  "Anagram" should {
    "do the job" in {
      Anagram.solve("aa"->"aa") must_== 0
    }
    "do the job2" in {
      Anagram.solve("a"->"b") must_== 1
    }
    "do the job3" in {
      Anagram.solve("abc"->"cba") must_== 0
    }
    "do the job4" in {
      Anagram.solve("xaxb"->"bbxx") must_== 1
    }
  }
}


