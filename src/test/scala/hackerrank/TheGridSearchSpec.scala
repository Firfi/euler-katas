package hackerrank

import org.specs2.mutable.Specification


class TheGridSearchSpec extends Specification {
  "TheGridSearch" should {
    "do the job" in {
      TheGridSearch.solve(
        TheGridSearch.Matrix(
          Map(
            (0->0)->1,
            (0->1)->2,
            (0->2)->3,
            (1->0)->4,
            (1->1)->5,
            (1->2)->6,
            (2->0)->7,
            (2->1)->8,
            (2->2)->9
          ),

          3, 3
        ),
        TheGridSearch.Matrix(
          Map(
            (0->0)->2,
            (0->1)->3,
            (1->0)->5,
            (1->1)->6
          ),

          2, 2
        )
      ) must_== true
    }
  }
}


