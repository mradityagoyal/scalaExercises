package mraditya.design.patterns.chapter4

import tests.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AdderTestSuite extends UnitSpec{
  import Adder._
  
  
  "An Adder" should "add 3,4 to 7" in {
    sum(3, 4) should be (7)
  }
  
  it should "sum floats" in {
    sum(1.2,2.3) should be (3.5)
  }
  
  val c1 = new Container(10)
  
  val c2 = new Container(11)
  
  
  "Containers" should "compare correctly" in {
    c1.compare(10) should be (true)
    
    c1.compare(11) should be (false)
    
    c2.compare(11) should be (true)
    
  }
  
  
}