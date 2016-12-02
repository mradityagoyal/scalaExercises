package mraditya.design.patterns

trait Alarm {
  def trigger(): String
}

trait Notifier {
  val notificationMessage: String

  def printNotification(): Unit = {
    println(notificationMessage)
  }

  def clear() = println("cleared alarm")
}

class Watch(brand: String, initialTime: Long) {
  def getTime(): Long = System.currentTimeMillis() - initialTime
}

trait AlarmNotifier {
  this: Notifier => 
  def trigger(): String
}

object WatchUser {
  def main(args: Array[String]) {

    val expensiveWatch = new Watch("Rado", 1000L) with Alarm with Notifier {
      override val notificationMessage = "The alarm is ringing"
      override def trigger(): String = "The alarm was triggered"
      override def clear(): Unit = println("alarm was cleared")
    }
    
    val cheapWatch = new Watch("China", 100L) with Alarm {
      def trigger(): String = "cheap alarm"
    }
    
    
    println(expensiveWatch.trigger())
    println(s"The time is ${expensiveWatch.getTime()}.")
    expensiveWatch.clear()
    expensiveWatch.printNotification()
    
    cheapWatch.trigger()
    cheapWatch.getTime()
    
    val almNotifierWatch = new Watch("NotifierAlarm", 500L) with AlarmNotifier with Notifier {
      override val notificationMessage = "notification"
      override def trigger() = "alarm triggered"
    }
    
    almNotifierWatch.getTime()
    almNotifierWatch.trigger()
    println(s"The notification is ${almNotifierWatch.notificationMessage}.")
    almNotifierWatch.clear()
    

  }
}