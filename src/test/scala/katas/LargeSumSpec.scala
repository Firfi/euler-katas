package katas

import org.specs2.mutable._

class LargeSumSpec extends Specification {

  "LargeSum" should {
    "do the job" in {
      LargeSum() must_== 233168
    }
  }

}
