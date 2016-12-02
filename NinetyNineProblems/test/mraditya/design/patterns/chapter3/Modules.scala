package mraditya.design.patterns.chapter3

trait Tick {
  trait Ticker {
    def count(): Int
    def tick(): Unit
  }
  def ticker: Ticker
}

trait TickUser extends Tick {

  class TickUserImpl extends Ticker {
    var curr = 0
    override def count(): Int = curr
    override def tick(): Unit = {
      curr = curr + 1
    }
  }
  object ticker extends TickUserImpl

}

trait Alarm {
  trait Alarmer {
    def trigger(): Unit
  }
  def alarm: Alarmer
}

trait AlarmUser extends Alarm with Tick{
  
  class AlarmUserImpl extends Alarmer{
    override def trigger(): Unit = {
      if(ticker.count() < 10 ){
        println("alarm triggered")
      }
      ticker.tick()
    }
  }
  object alarm extends AlarmUserImpl
}

object ModulesDemo extends AlarmUser with TickUser {
  def main(args: Array[String]): Unit = {
    println(s"alarm triggered ${alarm.trigger()}")
  }
}