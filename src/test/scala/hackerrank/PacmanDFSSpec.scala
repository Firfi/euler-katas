package hackerrank

import org.specs2.mutable.Specification


class PacmanDFSSpec extends Specification {
  "PacmanDFS" should {
    "do the job" in {
      val example = """3 9
                      |5 1
                      |7 20
                      |%%%%%%%%%%%%%%%%%%%%
                      |%--------------%---%
                      |%-%%-%%-%%-%%-%%-%-%
                      |%--------P-------%-%
                      |%%%%%%%%%%%%%%%%%%-%
                      |%.-----------------%
                      |%%%%%%%%%%%%%%%%%%%%""".stripMargin.split("\n")
      val result = """33
                     |3 9
                     |3 10
                     |3 11
                     |3 12
                     |3 13
                     |3 14
                     |3 15
                     |3 16
                     |2 16
                     |1 16
                     |1 17
                     |1 18
                     |2 18
                     |3 18
                     |4 18
                     |5 18
                     |5 17
                     |5 16
                     |5 15
                     |5 14
                     |5 13
                     |5 12
                     |5 11
                     |5 10
                     |5 9
                     |5 8
                     |5 7
                     |5 6
                     |5 5
                     |5 4
                     |5 3
                     |5 2
                     |5 1
                     |32
                     |3 9
                     |3 10
                     |3 11
                     |3 12
                     |3 13
                     |3 14
                     |3 15
                     |3 16
                     |2 16
                     |1 16
                     |1 17
                     |1 18
                     |2 18
                     |3 18
                     |4 18
                     |5 18
                     |5 17
                     |5 16
                     |5 15
                     |5 14
                     |5 13
                     |5 12
                     |5 11
                     |5 10
                     |5 9
                     |5 8
                     |5 7
                     |5 6
                     |5 5
                     |5 4
                     |5 3
                     |5 2
                     |5 1""".stripMargin
      var line = 0
      val Array(start1, start2) = example(line).split(" ").map(_.toInt)
      line += 1
      val Array(end1, end2) = example(line).split(" ").map(_.toInt)
      line += 1
      val Array(m, n) = example(line).split(" ").map(_.toInt)
      line += 1
      val field = line.until(m + line).map((l) =>
        example(l).toSeq
      )
      val (total, log, pathLen, path) = PacmanDFS.solve(field, start1->start2, end1->end2)
      s"""$total
         |${log.map((t) => s"${t._1} ${t._2}").mkString("\n")}
         |$pathLen
         |${path.map((t) => s"${t._1} ${t._2}").mkString("\n")}""".stripMargin must_== result
    }
  }
}


