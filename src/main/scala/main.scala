package it.albx79

import scala.sys.process.processInternal

type Item = Int
type Path = Seq[Node]

case class Node(value: Item, children: Option[(Node, Node)])

case class Triangle(node: Node):
  def children: List[Triangle] = node.children match
    case Some((c1, c2)) => List(Triangle(c1), Triangle(c2))
    case None => List.empty

  def minimalPath: Path = ???


object Triangle {
  def fromFile(data: Seq[String]): Triangle = {
    val tempNodes: List[List[Node]] = data.map(s => s.split(" ").map(n => Node(n.toInt, None)).toList).toList

    def connectChildren(heads: List[Node], children: List[Node]): List[Node] = {
      if (heads.length != children.length - 1) {
        println("Heads: " + heads)
        println("Children: " + children)
        throw new IllegalArgumentException()
      }
      heads.zipWithIndex.map {
        case (head, index) => head.copy(children = Some((children(index), children(index + 1))))
      }
    }

    val reversed = tempNodes.reverse
    val bottomRow = reversed.head
    val topRows = reversed.tail.reverse

    val connected = topRows
      .foldRight(bottomRow)(connectChildren)
      .reverse

    Triangle(connected.head)
  }
}

@main
def main(): Unit = {
  println("Hello world!")
}