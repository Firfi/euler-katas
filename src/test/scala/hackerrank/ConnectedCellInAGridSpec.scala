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
    "do the job 2" in {
      ConnectedCellInAGrid.solveWithPrehandle(
        List(
          "0 0 0 0",
          "0 0 0 0",
          "0 0 0 0"
        )
      ) must_== 0
    }
    "do the job 3" in {
      ConnectedCellInAGrid.solveWithPrehandle(
        List(
          "1 1 1",
          "1 1 1",
          "1 1 0"
        )
      ) must_== 8
    }
    "diagonal adjacency" in {
      ConnectedCellInAGrid.solveWithPrehandle(
        List(
          "0 1 1 1 1",
          "1 0 0 0 1",
          "1 1 0 1 0",
          "0 1 0 1 1",
          "0 1 1 1 0"
        )
      ) must_== 15
    }
  }
}


