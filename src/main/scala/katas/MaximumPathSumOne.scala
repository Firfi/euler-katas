package katas

/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
 */
object MaximumPathSumOne {
  def apply() = {
    implicit class Triangle[T](t: IndexedSeq[T]) {
      import TriangleOps._
      def getElement(row: Int, col: Int): T = {
        t(elementIndex(row, col))
      }
      def getElementOption(row: Int, col: Int): Option[T] = {
        t.get(elementIndex(row, col))
      }
      def getOrElse(i: Int, otherwise: T): T = {
        t.get(i).getOrElse(otherwise)
      }
      def get(i: Int): Option[T] = {
        if (i >= t.length) None
        else Some(t(i))
      }
    }
    object TriangleOps {
      def rowGap(r: Int): Int = r * (r + 1) / 2
      def currentRow(i: Int): Int =  {
        var ii = i
        var r = 0
        while (ii >= 0) {
          ii -= (r + 1)
          r += 1
        }
        r - 1
      }
      def elementIndex(row: Int, col: Int): Int = {
        rowGap(row) + col
      }
    }
    val input = "75\n95 64\n17 47 82\n18 35 87 10\n20 04 82 47 65\n19 01 23 75 03 34\n88 02 77 73 07 63 67\n99 65 04 28 06 16 70 92\n41 41 26 56 83 40 80 70 33\n41 48 72 33 47 32 37 16 94 29\n53 71 44 65 25 43 91 52 97 51 14\n70 11 33 28 77 73 17 78 39 68 17 57\n91 71 52 38 17 14 91 43 58 50 27 29 48\n63 66 04 68 89 53 67 30 73 16 69 87 40 31\n04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
      .split("\n|\\s").map(_.toLong)

    def solution(triangle: IndexedSeq[Long]): Long = {
      import scala.collection.mutable.ArrayBuffer
      val solutions = ArrayBuffer.empty[Long]
      triangle.copyToBuffer(solutions)
      triangle.zipWithIndex.reverseIterator.foreach({
        case (v: Long, i: Int) => {
          val row = TriangleOps.currentRow(i)
          val col = i - TriangleOps.rowGap(row)
          val leftIndex = TriangleOps.elementIndex(row + 1, col)
          val left = solutions.get(leftIndex)
          val rightIndex = TriangleOps.elementIndex(row + 1, col + 1)
          val right = solutions.get(rightIndex)
          val maxBottom: Long = (left.toList ++ right.toList).sorted.toIndexedSeq.get(1).getOrElse(0L)
          solutions(i) = v + maxBottom
        }
      })

      solutions.headOption.getOrElse(0L)
    }



    solution(input)
  }
}
