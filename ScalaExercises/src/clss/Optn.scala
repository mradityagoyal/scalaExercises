package clss

object Optn {
  def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
    if(flag) Some("Found Value") else None
  }
  
  def eng = "Hello"
  def hin = "namaste"
  
  def getClassVal(opt: Optn): Int = opt.clsVal
}

class Optn(private val clsVal : Int) {
  
}