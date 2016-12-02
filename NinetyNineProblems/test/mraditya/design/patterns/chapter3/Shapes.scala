package mraditya.design.patterns.chapter3

sealed abstract trait Shape

case class Point(x: Double, y: Double)

case class Circle(center: Point, radius: Int) extends Shape

case class Square(topLeft: Point, edge: Int) extends Shape

case class Rectangle(topLeft: Point, length: Int, width: Int) extends Shape

object Shape {
  def area(shape: Shape): Double = shape match{
    case Circle( _, r) => Math.PI * Math.pow(r, 2)
    case Square(_, s) => Math.pow(s, 2)
    case Rectangle(_, l, w) => l * w
  }
}

