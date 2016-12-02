package mraditya.design.patterns

trait A {
  def hello = "Hello from A"
}

trait B extends A {
  override def hello = "Hello from B"
}

trait C extends A {
  override def hello = " Hello from C"
}

trait D extends B with C {
  
}

object  DiamondProblem extends D{
  
  def main(args: Array[String]){
    println(hello)
  }
  
}