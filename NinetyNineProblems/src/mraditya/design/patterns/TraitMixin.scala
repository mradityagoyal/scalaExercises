package mraditya.design.patterns

class TraitMixin {
  trait A {
    def hello(): String = "Hello i am A"
    def pass(n: Int): String = s"Trait A said: 'You passed $n.'"
  }
  
  trait B{
    def hello(): String = "Hello i am B";
    def pass(n: Int): String = s"Trait B said: 'you passed $n.'"
  }
  
  
}