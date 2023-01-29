package it.albx79

type Item = Int
type Path = Seq[Item]

case class Triangle(numbers: List[List[Item]]):
  def apply(row: Int, col: Int): Item = numbers(row)(col)
  def minimalPath: Path = ???
object Triangle {
  def fromFile(data: Seq[String]): Triangle = Triangle(
    data.map(s => s.split(" ").map(n => n.toInt).toList).toList
  )
}

@main
def main(): Unit = {
  println("Hello world!")
}