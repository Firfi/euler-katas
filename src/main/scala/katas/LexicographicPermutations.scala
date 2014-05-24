package katas

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

/*
0
[1 0] = (1) * [0] + (1,0)
210 201 120 102 021 012
3 * [2 1 0] + 2 * [3 1 0] + 1 * [3 2 0] + 0 * [3 2 1]
[3 2 1 0] = (3) * [2 1 0] + (3,2) * [1 0] + (3,2,1) * [0]

7 * [9 8 6 5 4 3 2 1 0] .take (1000000 - 725760)

 */

object LexicographicPermutations {
  def apply[T](l: List[T]) = {
    /*
    this is bruteforce algorithm that dies on 10 values to permute. there's another one in books that works well,
    but in that case I won't need it as it could be greatly simplified analytically:
    let's say permutations formula for four values is
    [3 2 1 0] = 3 * [2 1 0] + 2 * [3 1 0] + 1 * [3 2 0] + 0 * [3 2 1]
    so in that case we have 4! permutations; and 3! permutations for recursive calls
    In assignment we have 10! (it is more than three millions) permutations that looks like this:
    [0 1 2 3 4 5 6 7 8 9] =  0 * [9 8 7 6 5 4 3 2 1] + ... + 9 * [8 7 6 5 4 3 2 1 0]
    so first 'nested' permutations 9 * [8 7 6 5 4 3 2 1 0] have 9! = 362880 variations, second the same;
    in sum we have 725760. Sum with third one is already more than a million so our result is somewhere inside this permutations:
    2 * [9 8 7 6 5 4 3 1 0]. So we could count this 9! permutations, take (1000000 - 725760)th element from there and prepend 2.
     */
    // as an option "0123456789".permutations.drop(999999).next
    "0123456789".permutations.drop(999999).next
    type Perms = Stream[List[T]]
    val cache = scala.collection.mutable.HashMap[List[T], Perms]()
    def perms(ss: List[T]): Perms = {
      cache.getOrElseUpdate(ss, {
        def multiply (pref: T, perms: Perms): Perms = perms.map(p => pref :: p)
        def plus (p1: Perms, p2: Perms): Perms = p1 #::: p2
        ss match {
          case List(e) => Stream(List(e))
          case list => {
            list.toStream.zipWithIndex.map({case (e,i) => multiply(e, perms(list.patch(i,Nil,1)))}).reduce(plus)
          }
        }
      })
    }
    (2 :: perms(l).take(1000000 - 725760).last).mkString("")
  }
  def apply(): String = apply(List(0,1,3,4,5,6,7,8,9))
}
