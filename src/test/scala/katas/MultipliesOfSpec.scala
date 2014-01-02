package katas

import org.specs2.mutable._

class MultipliesOfSpec extends Specification {

  "MultipliesOf" should {
    "do the job" in {
      MultipliesOf() must_== 233168
    }
  }

}
