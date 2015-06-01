package hackerrank
import org.specs2.mutable.Specification

/**
 * Created by firfi on 5/31/15 AD.
 */
class BiggerIsGreaterSpec extends Specification {
  "BiggerIsGreater" should {
    "do the job" in {
      BiggerIsGreater.solve("154") must_== "415"
      BiggerIsGreater.solve("dkhc") must_== "hcdk"
      BiggerIsGreater.solve("bb") must_== "no answer"
    }
  }
}


