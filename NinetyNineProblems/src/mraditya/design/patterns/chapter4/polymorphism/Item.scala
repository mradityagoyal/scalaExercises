package mraditya.design.patterns.chapter4.polymorphism

abstract class Item {
  def pack: String
}

class Fruit extends Item {
  override def pack: String = "I am a fruit and i'm packed in a bag."
}

class Drink extends Item {
  override def pack: String = "I'm a Drink in a glass"
}

object SybtypePolymorphismExample {
  def main(args: Array[String]): Unit = {
    val shoppingBasket: List[Item] = List(
      new Fruit(),
      new Drink())
    shoppingBasket.foreach(item => println(item.pack))
  }
}