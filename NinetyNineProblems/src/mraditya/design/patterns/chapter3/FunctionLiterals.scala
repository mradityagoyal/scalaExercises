package mraditya.design.patterns.chapter3

class FunctionLiterals {
  val sum = (a: Int, b: Int) => a + b 
  
  def runOperation(f: (Int, Int)=> Int, a: Int, b: Int): Int = {
    f(a,b)
  }
}

object FunctionLiterals {
  def main(args: Array[String]): Unit = {
    val obj = new FunctionLiterals
    println(s"3 + 9 = ${obj.sum(3,9)}")
  }
}