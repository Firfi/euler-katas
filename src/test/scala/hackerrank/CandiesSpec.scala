package hackerrank

import org.specs2._
import org.scalacheck._

class CandiesSpec extends mutable.Specification with ScalaCheck {

  def seqSpec(l: Seq[Int]) = {
    Candies.brute(l) must_== Candies.solve(l)
  }

  val smallIntegerList = for {
    n <- Gen.choose(0, 500)
    c <- Gen.listOfN(n, Gen.choose(1, 99999))
  } yield c

  implicit def abSmallIntegerList: Arbitrary[List[Int]] =
    Arbitrary(smallIntegerList)

  "random derp" >> prop { (l: List[Int]) =>
    seqSpec(l)
  }.set(minTestsOk = 200, workers = 3)

  "non random" should {
    "do the job" in {
      seqSpec(Seq(5,4,3,2,1))
    }
    "do the job" in {
      seqSpec(Seq(1,1,1,1))
    }
    "do the job" in {
      seqSpec(Seq(2, 4, 2, 6, 1, 7, 8, 9, 2, 1))
    }
  }

}


