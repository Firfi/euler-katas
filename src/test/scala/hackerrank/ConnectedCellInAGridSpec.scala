package hackerrank

import org.specs2.mutable.Specification


class ConnectedCellInAGridSpec extends Specification {
  "ConnectedCellInAGrid" should {
    "do the job" in {
      ConnectedCellInAGrid.solveWithPrehandle(
        List(
          "1 1 0 0",
          "0 1 1 0",
          "0 0 1 0",
          "1 0 0 0"
        )
      ) must_== 5
    }
  }
}


