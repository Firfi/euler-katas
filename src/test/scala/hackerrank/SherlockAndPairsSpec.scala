package hackerrank

import org.specs2.mutable.Specification


class SherlockAndPairsSpec extends Specification {
  def generate(s: String, r: Int) = {
    val v = SherlockAndPairs.solve(s.split(" ").filter(_ != "").map((a) => BigInt(a.toInt))) must_== BigInt(r)
    v
  }
  "SherlockAndPairs" should {
    "do the job" in {
      SherlockAndPairs.solve(Seq(1, 2, 3).map((a) => BigInt(a))) must_== BigInt(0)
    }
    "do the job" in {
      SherlockAndPairs.solve(Seq(1, 1, 2).map((a) => BigInt(a))) must_== BigInt(2)
    }
    "do the job" in {
      generate("2 2 2 2 2 2 2 2 2 2", 90)
    }
    "do the job" in {
      generate("88 88 815 546 88 365 44 751 583 88", 12)
    }
    "do the job" in {
      generate("1", 0)
    }
    "do the job" in {
      generate("927 737 60 427 427 173 764 691 212 541", 2)
    }
  }
}


