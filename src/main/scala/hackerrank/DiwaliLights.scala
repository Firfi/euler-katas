package hackerrank

object DiwaliLights {
  def solve(n: Int): BigInt = {
    val m = 100000
    (BigInt(2).modPow(BigInt(n), BigInt(m)) - 1) % m
  }
  def main(args: Array[String]): Unit = {
    val n = readInt()
    1.to(n).map((_) => {
      solve(readInt())
    }).foreach(println)
  }
}
