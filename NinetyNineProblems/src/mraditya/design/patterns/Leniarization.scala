package mraditya.design.patterns

class Animal extends AnyRef
class Dog extends Animal 

class MultiplierIdentity {
  def identity: Int = 1
}

trait DoubleMultiplierIdentity extends MultiplierIdentity {
  override def identity: Int = 2 * super.identity
}

trait TripleMultiplierIdentity extends MultiplierIdentity {
  override def identity: Int = 3 * super.identity
}

class ModifiedIdentity1 extends DoubleMultiplierIdentity with TripleMultiplierIdentity 

class ModifiedIdentity2 extends DoubleMultiplierIdentity with TripleMultiplierIdentity{
  override def identity: Int = super[DoubleMultiplierIdentity].identity
}

class ModifiedIdentity3 extends DoubleMultiplierIdentity with TripleMultiplierIdentity{
  override def identity: Int = super[TripleMultiplierIdentity].identity
}

class ModifiedIdentity4 extends TripleMultiplierIdentity with DoubleMultiplierIdentity 

class ModifiedIdentity5 extends TripleMultiplierIdentity with DoubleMultiplierIdentity{
  override def identity: Int = super[DoubleMultiplierIdentity].identity
}

class ModifiedIdentity6 extends TripleMultiplierIdentity with DoubleMultiplierIdentity{
  override def identity: Int = super[TripleMultiplierIdentity].identity
}

object Leniarization {
  
  def main(args: Array[String]){
    val ins1 = new ModifiedIdentity1
    val ins2 = new ModifiedIdentity2
    val ins3 = new ModifiedIdentity3
    val ins4 = new ModifiedIdentity4
    val ins5 = new ModifiedIdentity5
    val ins6 = new ModifiedIdentity6
    
    println(s"Result 1 : ${ins1.identity}")
    println(s"Result 2 : ${ins2.identity}")
    println(s"Result 3 : ${ins3.identity}")
    println(s"Result 4 : ${ins4.identity}")
    println(s"Result 5 : ${ins5.identity}")
    println(s"Result 6 : ${ins6.identity}")
    
    
  }
  
}