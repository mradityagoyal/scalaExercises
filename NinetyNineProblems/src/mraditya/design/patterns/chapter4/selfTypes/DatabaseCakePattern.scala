package mraditya.design.patterns.chapter4.selfTypes

import scala.collection.mutable.MutableList
import scala.util.Try
import scala.util.Success
import scala.util.Failure

trait DatabaseCP[T] {
  def save(data: T): Unit
  def get(index: Int): Try[T]
}

trait UserDb[T] {
  this: DatabaseCP[T] =>
  val users: MutableList[T] = MutableList.empty
  override def save(data: T): Unit = users.+=:(data)
  override def get(index: Int): Try[T] =
    {
      try {
        Success(users(index))
      } catch {
        case idxOOBEx: IndexOutOfBoundsException => Failure(idxOOBEx)
      }
    }

}

trait EmailService[T] {
  // ends up getting acecess to DatabaseCP
  this: UserDb[T] =>

}

object EmailSender extends EmailService[String] with UserDb[String] with DatabaseCP[String] {
  def main(args: Array[String]): Unit = {
    save("Hello")
    println(get(1).getOrElse("Not found"))
    println(get(3) match {
      case Success(x) => x
      case Failure(f) => None
    })
  }
}


