package mraditya.design.patterns.chapter4.selfTypes

import scala.collection.mutable.MutableList
import scala.util.Try

trait DB {
  def connect(): Unit = println("connected")
  def close(): Unit = println("disconnected")
  def dropDatabase(): Unit = println("DB Dropped")
}

trait UserDB[T] {
  self: DB =>
  val users: MutableList[T] = MutableList.empty
  def createUser(userName: T): Unit = {
    connect()
    try {
      println(s"Putting in User: $userName")
      users.+=:(userName)
    } finally {
      close()
    }
  }

  def getUser(userName: T): Option[T] = {
    connect()
    try {
      println(s"getting User: $userName")
      users.filter(_.equals(userName)).headOption
    } finally {
      close()
    }

  }
}

trait UserService[T] {
  self: UserDB[T] =>
  def bad(): Unit = {
  }
}

object UserSericeTest  {

  val userService = new UserService[String] with UserDB[String] with DB
  def main(args: Array[String]): Unit = {
    userService.createUser("aditya")
    println(userService.getUser("aditya").getOrElse("not found"))
    println(userService.getUser("goyal").getOrElse("not found"))
  }

}