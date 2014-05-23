package katas

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

object SelfPowers {
  // so we don't care about any numbers extept 10 last. it is actual for both operations, + and * that used here
  // example for "1 last number":
  // +: 12 + 15 = 27 => 10 + 10 + 2 + 5 = 20 + 7 => so remove first numbers and we have 7 = 7
  // *: 14 * 15 = 210 => (10 + 4) * (10 + 5) = 210 => 100 + 40 + 50 + 20 = 210 so remove first numbers and we have 0 = 0
  def apply() = {
    def trimmed(op: (Long, Long) => Long)(a1: Long, a2: Long): Long = op(a1, a2) % 10000000000L
    Stream.from(1).map(n => Stream.continually(n.toLong).take(n).reduce(trimmed(_ * _))).take(1000).reduce(trimmed(_ + _))
  }
}
