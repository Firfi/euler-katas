package codility

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 9/12/14
 * Time: 11:39 PM
 * To change this template use File | Settings | File Templates.
 */
object GenomicRangeQuery {
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val impacts = Map('A'->1, 'C'->2, 'G'->3, 'T'->4)
    val dna = s.map(c => impacts(c).toByte).toArray
    val l = dna.length
    val sumPrefixes = Array.fill(l + 1, 4)(0)
    for ((n, i) <- dna.zip(Stream.from(1))) {
      for (j <- 0.to(3)) {
        sumPrefixes(i)(j) = sumPrefixes(i - 1)(j)
      }
      sumPrefixes(i)(n - 1) += 1
    }
    p.zip(q).map({
      case (q1, q2) => {
        0.until(4).map(t => (t, sumPrefixes(q2 + 1)(t) - sumPrefixes(q1)(t))).find(_._2 > 0).get._1 + 1
      }
    })
  }
}
