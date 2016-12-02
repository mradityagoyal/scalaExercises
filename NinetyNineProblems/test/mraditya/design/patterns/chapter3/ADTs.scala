package mraditya.design.patterns.chapter3

sealed abstract trait Month
case object January extends Month
case object February extends Month
case object March extends Month
case object April extends Month
case object May extends Month
case object June extends Month
case object July extends Month
case object August extends Month
case object September extends Month
case object October extends Month
case object November extends Month
case object December extends Month

object MonthDemo {
  //  def main(args: Array[String]): Unit = { 
  //    val month: Month = February 
  //    System.out.println(s"The current month is: $month") 
  //  } 
}

object Month {
  def toInt(month: Month): Int = month match {
    case January => 1
    case February => 2
    case March => 3
    case April => 4
    case May => 5
    case June => 6
    case July => 7
    case August => 8
    case September => 9
    case October => 10
    case November => 11
    case December => 12
    case _ => -1
  }
}

sealed case class RGB(r: Int, g: Int, b: Int)

object RGBDemo {
  def main(args: Array[String]): Unit = {
    val magenta = RGB(255, 0, 255)
    println(s"Magenta in RGB: $magenta.")
    
    println(s"January is  ${Month.toInt(January)}'st month")
  }
}