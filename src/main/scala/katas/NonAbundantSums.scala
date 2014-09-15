import math._
import scala.util._

object Player {
  def main(args: Array[String]) {
    // Read init information from standard input, if any
    type Dir = String
    val (w, h) = {
      val wh = readLine().split(" ")
      wh.head.toInt->wh.last.toInt
    }
    val n = readLine().toInt
    val (x0, y0) = {
      val xy = readLine().split(" ")
      xy.head.toInt->xy.last.toInt
    }
    type Width = Int
    type Height = Int
    type X = Int
    type Y = Int
    type XOffset = Int
    type YOffset = Int
    def map(x: X, y: Y, dir: Dir, w: Width, h: Height): (XOffset, YOffset, Width, Height) = {
      dir match {
        case "U" => (x, 0, 1, y+1)
        case "UR" => (x, 0, w-x, y+1)
        case "R" => (x, y, w-x, 1)
        case "DR" => (x, y, w-x, h-y)
        case "D" => (x, y, 1, h-y)
        case "DL" => (0, y, x+1, h-y)
        case "L" => (0, y, x+1, 1)
        case "UL" => (0, 0, x+1, y+1)
      }
    }
    def center(w: Width, h: Height) = (w/2, h/2)
    while (true) {
      val dir = readLine()

      // Read information from standard input

      // Compute logic here

      // Console.err.println("Debug messages...")

      // Write action to standard output
      println("0 0")
    }

  }
}