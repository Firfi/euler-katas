package katas

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object SmallestMultiple {
  def apply() = {
    val init = (1L to 20L).reduce(_ * _)
    var i = 20L
    var res = init
    while (i < init) {
      if ((3 to 20).forall({
        nn => i % nn == 0
      })) {
        res = i
        i = init
      } else {
        i = i + 1
      }
    }
    res
  }
}
