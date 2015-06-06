package hackerrank



object StringChain {
  def longest_chain(ws: Array[String]): Int = {
    val cache = collection.mutable.HashMap[String, Int]()
    def wordCount(w: String, d: Array[String]): Int = {
      val l = w.length
      if (l == 1) {
        1
      } else {
        var max = 1
        w.zipWithIndex.foreach({case (s, i) =>
          val sb = new StringBuilder(l - 1)
          if (i == 0) {
            sb.append(w.substring(1))
          } else {
            sb.append(w.substring(0, i)).append(w.substring(i + 1, w.length()))
          }
          val sub = sb.toString()
          d.foreach((word) => {
            if (word.equals(sub)) {
              var chain = 0
              chain = 1 + cache.getOrElse(sub, wordCount(sub, d))
              max = Math.max(max, chain)
            }
          })
        })
        cache.put(w, max)
        max
      }

    }
    (ws.map((w) => wordCount(w, ws)) ++ Iterator(1)).max
//    val hash = ws.toSet
//    val sortedWs = ws.sortBy(_.length).reverse
//    val max = 0
//    sortedWs.foldLeft(max)({case (mx, word) =>
//      if (word.length <= mx) mx
//      else {
//        // do search
//        def doSearch(w: String, hash: Set[String]): Int = {
//          def _do(w: String, acc: Int): Int = {
//            val r = (w.combinations(w.length - 1).filter((s) => {
//              s != "" && hash.contains(s)
//            }).map((s) => Math.max(_do(s, acc + 1), acc + 1)) ++ Iterator(acc)).max
//            r
//          }
//          val mx = _do(w, 0)
//          if (mx > 0) { // it is number of steps - and we need _chain length_
//            mx + 1
//          } else 0
//        }
//        Math.max(doSearch(word, hash), mx)
//      }
//    })
  }
  def main(args: Array[String]): Unit = {
    // readInt, readLine ...
  }
}
