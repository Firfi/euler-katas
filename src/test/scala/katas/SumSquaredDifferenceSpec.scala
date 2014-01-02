package katas

import org.specs2.mutable._

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 12/30/13
 * Time: 3:42 AM
 * To change this template use File | Settings | File Templates.
 */
class SumSquaredDifferenceSpec extends Specification {
  "SmallSumSquaredDifferenceestMultiple" should {
    "do the job" in {
      SumSquaredDifference() must_== 25164150
    }
  }
}
