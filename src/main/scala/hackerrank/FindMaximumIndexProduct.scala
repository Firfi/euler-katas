package hackerrank

object FindMaximumIndexProduct {
  def isSorted(a: Array[Int]): Boolean = {
    a match {
      case Array(h, t@_*) => a.zip(t).forall {
        case (x, y) => x < y
      }
      case _ => true
    }
  }
  def solve(a: Array[Int]): Long = {
    val l = a.length
    if (l < 3) 0
    else if (isSorted(a) || isSorted(a.reverse)) {
      0
    } else {
      val left = collection.mutable.ArrayBuffer.fill(l){0}
      val right = collection.mutable.ArrayBuffer.fill(l){0}
      var i = 1
      while (i < l) {
        if (a(i) == a(i - 1)) {
          left(i) = left(i - 1)
        } else if (a(i) < a(i - 1)) {
          left(i) = i
        } else { // n2 > n
          var j = left(i - 1)
          while (j >= 0) {
            if (a(j) > a(i)) {
              left(i) = j + 1
              j = 0 // break
            }
            j -= 1
          }
        }
        i += 1
      }
      i = l - 2
      while (i >= 0) {
        if (a(i + 1) == a(i)) {
          right(i) = right(i + 1)
        } else if (a(i) < a(i + 1)) {
          right(i) = i + 2
        } else { // n2 > n
        var j = right(i + 1)
          while (j < l) {
            if (a(j) > a(i)) {
              right(i) = j + 1
              j = l // break
            }
            j += 1
          }
        }
        i -= 1
      }

      var ret = 0L
      i = 1
      while (i < l - 1) {
        ret = Math.max(ret, left(i).toLong * right(i).toLong)
        i += 1
      }
      ret
    }

  }

  def main(args: Array[String]): Unit = {
    val n_ = readInt() // don't care
    println(solve(readLine().split(" ").map(_.toInt).toArray))
  }
}
