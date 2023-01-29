package it.albx79

import java.io.IOException
import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.sys.process.processInternal

type Item = Int
type Path = Seq[Triangle]

case class Triangle(value: Item, children: Seq[Triangle], cost: Int):
  require(children.isEmpty || children.length == 2)

  def minimalPath: Path = this +: (if (children.isEmpty) Seq.empty else children.minBy(_.cost).minimalPath)

object Triangle {
  def fromFile(data: Seq[String]): Triangle = {
    val tempNodes = data.map(s => s.split(" ").map(n => n.toInt).toVector)

    def connectChildren(heads: Seq[Int], children: Seq[Triangle]): Seq[Triangle] = {
      if (heads.length != children.length - 1) {
        throw new IllegalArgumentException(s"Heads: $heads\nChildren: $children")
      }
      heads.zipWithIndex.map { case (head, index) =>
        val c1 = children(index)
        val c2 = children(index + 1)
        Triangle(
          value = head,
          children = Seq(c1, c2),
          cost = Math.min(c1.cost, c2.cost) + head
        )
      }
    }

    val reversed = tempNodes.reverse
    val bottomRow = reversed.head.map(n => Triangle(value = n, children = Seq.empty, cost = n))
    val topRows = reversed.tail.reverse

    topRows
      .foldRight(bottomRow)(connectChildren)
      .reverse
      .head
  }
}

@main
def main(): Unit = {
  val lines = Iterator.continually(StdIn.readLine()).takeWhile(_ != null)
  val triangle = Triangle.fromFile(lines.toSeq)
  println(s"Minimal path is: ${triangle.minimalPath.map(_.value).mkString(" + ")} = ${triangle.cost}")
}