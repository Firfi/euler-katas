package katas

import org.specs2.mutable.Specification

class LargestProductInSeriesSpec extends Specification {
  "LargestProductInSeries" should {
    "do the job" in {
      LargestProductInSeries() must_== 6857L
    }
  }
}
