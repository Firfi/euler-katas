package hackerrank

object StringChain {
  def longest_chain(ws: Array[String]): Int = {
    val hash = ws.toSet
    val sortedWs = ws.sortBy(_.length).reverse
    val max = 0
    sortedWs.foldLeft(max)({case (mx, word) =>
      if (word.length <= mx) mx
      else {
        // do search
        def doSearch(w: String, hash: Set[String]): Int = {
          def _do(w: String, acc: Int): Int = {
            val r = (w.combinations(w.length - 1).filter((s) => {
              s != "" && hash.contains(s)
            }).map((s) => Math.max(_do(s, acc + 1), acc + 1)) ++ Iterator(acc)).max
            r
          }
          val mx = _do(w, 0)
          if (mx > 0) { // it is number of steps - and we need _chain length_
            mx + 1
          } else 0
        }
        Math.max(doSearch(word, hash), mx)
      }
    })
  }
  def main(args: Array[String]): Unit = {
    // readInt, readLine ...
  }
}
