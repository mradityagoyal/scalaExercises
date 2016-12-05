package mraditya.design.patterns.chapter4

case class Person(name: String)

trait Adder[T] {
  def sum(a:T , b: T): T
}

object Adder {
  def sum[T: Adder](a: T, b: T): T =  {
    implicitly[Adder[T]].sum(a, b)
  }
  
  implicit val int2Adder: Adder[Int] = new Adder[Int] {
    override def sum(a: Int, b: Int) = a + b
  }
  
//  implicit val double2Adder: Adder[Double] = new Adder[Double] {
//    override def sum(a: Double, b: Double) = a + b
//  }
  
  implicit val str2Adder: Adder[String] = new Adder[String] {
    override def sum(a: String, b: String) = a + "-contact-" + b
  }
  
  implicit def numeric2Adder[T: Numeric]: Adder[T] = new Adder[T]{
    override def sum(a: T, b: T): T = implicitly[Numeric[T]].plus(a, b)
  }
}

object AdhocPolymorphismExample {
  import Adder._
  def main(args: Array[String]): Unit = {
    println(s"The sum of 1 and 2 is ${sum(1,2)}")
    println(s"The sum of 1 and 2 is ${sum("Adi","try")}")
    println(s"the sum of floats is ${sum(1.5, 2.45)}")
  }
}

class Container[T](data: T) {
  def compare(other: T) = data.equals(other)
}



