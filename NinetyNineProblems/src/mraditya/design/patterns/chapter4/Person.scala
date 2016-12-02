package mraditya.design.patterns.chapter4

case class Person(name: String)

trait Adder {
  def sum[T](a:T , b: T)(implicit numeric: Numeric[T]): T = numeric.plus(a, b)
}

class Container[T](data: T) {
  def compare(other: T) = data.equals(other)
}



