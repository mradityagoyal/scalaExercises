package mraditya.design.patterns.chapter3

import tests.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Chapter3TestSuite extends UnitSpec {

  val instance = new FunctionLiterals

  "FunctionLiteral" should "sum properly" in {
    instance.sum(3, 5) should be(8)
  }

  it should "runSum properly" in {
    instance.runOperation(instance.sum, 3, 5) should be(8)
  }
  it should "run Math.max properly" in {
    instance.runOperation(Math.max, 4, 9) should be(9)
  }

}