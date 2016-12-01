package tests

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import clss.Optn
import asrt.AssertTest
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ObjTestSuite extends UnitSpec{
  
  "Optn companion object " should "be able to access private value " in {
    val op = new Optn(10)
    Optn.getClassVal(op) should be (10)
  }
  
}