package codility

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
Array A contains only 0s and/or 1s:
0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
For example, consider array A such that:
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
Write a function:
object Solution { def solution(A: Array[Int]): Int }
that, given a non-empty zero-indexed array A of N integers, returns the number of passing cars.
The function should return −1 if the number of passing cars exceeds 1,000,000,000.
For example, given:
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 */
object PassingCars {
  def solution(a: Array[Int]): Int = {
    val MAX = 1000000000
    val l = a.length
    val ps = Array.fill(l + 1)(0)
    for ((n, i) <- a.zip(Stream.from(1))) {
      ps(i) = ps(i - 1) + n
    }
    val zeroIndexes = a.zipWithIndex.filter(_._1 == 0).map(_._2)
    val l2 = zeroIndexes.length
    if (l2 == 0 || l2 == l) 0
    else {
      var sum = 0
      for (i <- zeroIndexes) {
        sum += ps(l) - ps(i)
        if (sum > MAX) return -1
      }
      sum
    }
  }
}

/* code with zips and soforth here
 val l = a.length
    val ps = a.foldLeft((List(0), 0))({
      case ((r, s), n) => {
        val ns = s + n
        (r :+ ns, ns)
      }
    })._1.toArray
    val zeroIndexes = a.zipWithIndex.foldLeft(List[Int]())({
      case (acc, (n, i)) => if (n != 0) acc else acc :+ i
    })
    val l2 = zeroIndexes.length
    if (l2 == 0 || l2 == l) 0
    else {
      var sum = 0
      for (i <- zeroIndexes) {
        sum += ps(l) - ps(i)
        if (sum > MAX) return -1
      }
      sum
    }

 */
