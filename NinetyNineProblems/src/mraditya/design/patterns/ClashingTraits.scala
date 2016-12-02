package mraditya.design.patterns

trait FormalGreeting {
  def greet(): String = "Hello Sir"
}

trait InformalGreeting {
  def greet(): String = "what's up "
}

class ClashingTraits extends FormalGreeting with InformalGreeting{
  override def greet(): String = super[FormalGreeting].greet()
}

object ClashingTraitsUser {
  def main(args: Array[String]): Unit = {
    val greeter = new ClashingTraits()
    println(greeter.greet())
  }
}