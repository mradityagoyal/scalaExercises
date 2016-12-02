package mraditya.design.patterns.chapter4

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import tests.UnitSpec

@RunWith(classOf[JUnitRunner])
class PrintersTestSuite extends UnitSpec{
  
  val lp = new LaserPrinter
  
  "Laser printer" should "print on paper" in {
    lp.print(Text(), Toner(), Paper()) should be ("Hi")
  }
  
}