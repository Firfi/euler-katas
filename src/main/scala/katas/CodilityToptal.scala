package katas

/**
 * every decimal can be written in binary. here we use this binary formula: decimal m = sum(n*(-2)`^i`) where i is our binaries indices
 * i.e. 42 = 0111111: 0 - 2 + 4 - 8 + 16 - 32 + 64
 * find most succinct binary format for any number
 * complexity approx log()
 */
object CodilityToptal {
  def apply(m: Int): Seq[Boolean] = {
    def step(t: Boolean, i: Int): Int = {
      if (t) Math.pow(-2, i).toInt else 0
    }
    def isEven(v: Int): Boolean = v % 2 == 0
    def parentValue(tree: Stream[Int], i: Int): Int = {
      val ni = parentIndex(tree, i)
      if (ni >= 0) tree(ni) else 0
    }
    def parentIndex(tree: Stream[Int], i: Int): Int = {
      val m = if (isEven(i)) 2 else 1
      (i - m) / 2
    }
    // indices from node to triangle 'head'
    def parentLine(tree: Stream[Int], i: Int): Seq[Int] = {
      lazy val s: Stream[Int] = i #:: Stream.from(1).map(ii => parentIndex(tree, s(ii - 1))).takeWhile(_ > 0)
      s.toList
    }
    def level(tree: Stream[Int], i: Int): Int = {
      parentLine(tree, i).length - 1
    }
    lazy val tree: Stream[Int] = 0 #:: Stream.from(1).map(i =>
      step(isEven(i), level(tree, i)) + parentValue(tree, i)
    )
    val lastIndex = tree.indexOf(m)
    val res = tree.take(lastIndex + 1)
    val mindex = res.length - 1
    parentLine(tree, mindex).reverse.map(i => isEven(i))
  }
}


