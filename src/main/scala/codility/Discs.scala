package codility

/**
 * Given an array A of N integers, we draw N discs in a 2D plane such that the I-th disc is centered on (0,I) and has a radius of A[I]. We say that the J-th disc and K-th disc intersect if J ≠ K and J-th and K-th discs have at least one common point.
Write a function:
object Solution { def solution(A: Array[Int]): Int }
that, given an array A describing N discs as explained above, returns the number of pairs of intersecting discs. For example, given N=6 and:
A[0] = 1  A[1] = 5  A[2] = 2
A[3] = 1  A[4] = 4  A[5] = 0
intersecting discs appear in eleven pairs of elements:
0 and 1,
0 and 2,
0 and 4,
1 and 2,
1 and 3,
1 and 4,
1 and 5,
2 and 3,
2 and 4,
3 and 4,
4 and 5.
so the function should return 11.
The function should return −1 if the number of intersecting pairs exceeds 10,000,000.
Assume that:
N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2147483647].
Complexity:
expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.

 */
object Discs {
  def solution(a: Array[Int]): Int = {
    val l = a.length
    if (l < 2) return 0
    val MAX = 10000000
    type Open = Boolean
    val p: Array[(Long, Open)] = a.zipWithIndex.map({case (r, x) => x.toLong + r}).map(n => (n, true))
    val q: Array[(Long, Open)] = a.zipWithIndex.map({case (r, x) => x.toLong - r}).map(n => (n, false))
    val dots = (p ++ q).sortWith({case ((d1, o1), (d2, o2)) => {
      if (d1 > d2) true
      else if (d1 < d2) false
      else if (o1 != o2) o1
      else o2
    }})
    var opened = 0
    var count = 0
    for ((dot, o: Open) <- dots) {
      if (o) opened += 1
      else {
        count += (opened - 1)
        opened -= 1
        if (count > MAX) return -1
      }
    }
    count
  }
}
