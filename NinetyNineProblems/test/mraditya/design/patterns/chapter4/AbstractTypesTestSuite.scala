package mraditya.design.patterns.chapter4

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import tests.UnitSpec

@RunWith(classOf[JUnitRunner])
class AbstractTypesTestSuite extends UnitSpec{
  
  val sContainer = new StringContainer("Hello")
  
  "A string Container" should "compare correctly" in {
    sContainer.compare("Hello") should be (true)
  }
  
  
}