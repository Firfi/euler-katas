package hackerrank

import org.specs2.mutable.Specification


class DiwaliLightsSpec extends Specification {
  "DiwaliLights" should {
    "do the job" in {
      DiwaliLights.solve(1) must_== BigInt(1)
    }
    "do the job" in {
      DiwaliLights.solve(2) must_== BigInt(3)
    }
    "do the job" in {
      DiwaliLights.solve(8291) must_== BigInt(4447)
    }
    "do the job" in {
      DiwaliLights.solve(2) must_== BigInt(3)
    }

  }
}


