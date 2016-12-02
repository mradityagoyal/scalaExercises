package mraditya.design.patterns

import tests.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TraitMixinTestSuite extends UnitSpec {
  class TraitATest extends A
  val instanceA = new TraitATest
  "hello" should "greet properly" in {
    instanceA.hello should be("Hello from A")
  }

  class TraitBTest extends B
  val instanceB = new TraitBTest
  "HelloB " should "greet properly" in {
    instanceB.hello should be("Hello from B")
  }
  
  "hello A " should "be 'Hello from A'" in new A{
    hello should be ("Hello from A")
  }
  
   "hello B" should "be 'Hello from B'" in new B{
    hello should be ("Hello from B")
  }

}