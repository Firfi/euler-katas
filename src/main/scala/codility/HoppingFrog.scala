package codility

/**
 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
Count the minimal number of jumps that the small frog must perform to reach its target.
Write a function:

int solution(int X, int Y, int D);


int solution(int X, int Y, int D);


int solution(int X, int Y, int D);


class Solution { int solution(int X, int Y, int D); }


class Solution { public int solution(int X, int Y, int D); }


object Solution { def solution(X: Int, Y: Int, D: Int): Int }


function solution(X, Y, D);


function solution(X, Y, D)


function solution($X, $Y, $D);


function solution(X: longint; Y: longint; D: longint): longint;


def solution(X, Y, D)


sub solution { my ($X, $Y, $D)=@_; ... }


def solution(x, y, d)


Private Function solution ( X As Integer, Y As Integer, D As Integer ) as Integer

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
For example, given:
  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:
after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100

Assume that:
X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.

Complexity:
expected worst-case time complexity is O(1);
expected worst-case space complexity is O(1).
 */
object HoppingFrog {
  def solution(x: Int, y: Int, d: Int): Int = {
    val len = Math.max(0, y - x)
    val leftover = len % d
    val addedLen = if (leftover > 0) d - leftover else 0
    val fullLen = len.toDouble + addedLen
    (fullLen / d).toInt
  }
}