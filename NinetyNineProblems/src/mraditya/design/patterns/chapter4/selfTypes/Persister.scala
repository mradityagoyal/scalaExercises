package mraditya.design.patterns.chapter4.selfTypes

import scala.collection._

trait Database[T] {
  def save(data: T)
}

trait History {
  def add(): Unit = {
    println("added to history")
  }
}

trait Mystry {
  def add(): Unit = {
    println("mystry added!")
  }
}

trait MemoryDatabase[T] extends Database[T] {
  val db: mutable.MutableList[T] = mutable.MutableList.empty

  override def save(data: T): Unit = {
    println("saving to memory db")
    db.+=:(data)
  }
}

trait FileDatabase[T] extends Database[T] {
  def save(data: T): Unit = println("saving to fileDB")
}

trait Persister[T] {
  self: Database[T] with History with Mystry =>
    def persist(data: T): Unit = {
      println("persisnting to DB")
      save(data)
      add()
    }
}

class FilePersister[T] extends Persister[T] with FileDatabase[T] with History with Mystry{
  override def add(): Unit = super[Mystry].add()
}

class MemPersister[T] extends Persister[T] with MemoryDatabase[T] with History with Mystry{
  override def add(): Unit = super[History].add()
}



object PersistExample {
  def main(args: Array[String]): Unit = {
    val fPersister = new FilePersister[String]
    val mPersister = new MemPersister[String]
    fPersister.persist("Hello1")
    mPersister.persist("Hello")
  }
}