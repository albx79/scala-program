package it.albx79

import org.scalatest.funsuite.AnyFunSuite

class MainTest extends AnyFunSuite:

  private val data = Seq("7", "6 3", "3 8 5", "11 2 10 9")

  test("We can store the triangle in a text file with each row on a separate one minimal path line, and spaces between the numbers.") {
    val triangle = Triangle.fromFile(data)
    assert(triangle.value == 7)
    assert(triangle.children(1).children(1).children(1).value == 9)
    assert(triangle.children.head.children.head.children.head.value == 11)
  }

  test("The cost associated to a triangle is the cost of the minimal path") {
    assert(Triangle.fromFile(data).cost == 18)
  }

  test("(7, 6, 3, 2) is the minimal path.") {
    val triangle = Triangle.fromFile(data)
    val minPath = triangle.minimalPath
    assert(minPath.map(_.value).toList == List(7, 6, 3, 2))
  }


