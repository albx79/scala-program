package it.albx79

import org.scalatest.funsuite.AnyFunSuite

class MainTest extends AnyFunSuite:

  private val data = Seq("7", "6 3", "3 8 5", "11 2 10 9")

  test("We can store the triangle in a text file with each row on a separate one minimal path line, and spaces between the numbers.") {
    val triangle = Triangle.fromFile(data)
    assert(triangle.node.value == 7)
    assert(triangle.children(1).children(1).children(1).node.value == 9)
    assert(triangle.children.head.children.head.children.head.node.value == 11)
  }

  test("7 + 6 + 3 + 2 = 18 is the minimal path.") (pending)
//  {
//    val triangle = Triangle.fromFile(data)
//    val minPath = triangle.minimalPath
//    assert(minPath.sum == 18)
//    assert(minPath.head == 7)
//    assert(minPath.last == 2)
//  }


