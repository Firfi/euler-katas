package hackerrank

import org.specs2.mutable.Specification


class BotSavesPrincessSpec extends Specification {
  "BotSavesPrincess" should {
    "do the job" in {
      BotSavesPrincess.solve(
        Seq(
          Seq('-', '-', '-'),
          Seq('-', 'm', '-'),
          Seq('p', '-', '-')
        )
      ) must_== Seq("DOWN", "LEFT")
    }
  }
}


