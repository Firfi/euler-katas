package katas.blacksheet

/**
 * Created with IntelliJ IDEA.
 * User: firfi
 * Date: 1/2/14
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
object LatticeGridPainter {
  def main(args: Array[String]) {
    val DIMENSIONS = 2
    val POWERS = 4
    type Coord = Int
    type Power = Int
    type Count = Int
    val paths = collection.mutable.HashMap[Seq[Coord], Count](List.fill(DIMENSIONS)(0)->1).withDefaultValue(0)
    def fire(dims: List[(Coord, Power)]) {
      dims.zipWithIndex.filter(_._1._2 > 0).map({
        case ((coord, power), i) => dims.updated(i, (coord+1, power-1))
      }).foreach {
        ds: List[(Coord, Power)] => {
          paths(ds.map(_._1)) += 1
          fire(ds)
        }
      }
    }
    fire(List.fill(DIMENSIONS)(0).map(_->POWERS))
    println(paths.toList.sortBy(_._1.mkString).grouped(POWERS + 1).map(_.map(_._2).mkString("---")).mkString("\n"))
  }
}
