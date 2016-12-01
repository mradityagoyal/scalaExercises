package tests

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import asrt.AssertTest
import clss.Optn

@RunWith(classOf[JUnitRunner])
class AssertTestSuite extends UnitSpec {

  "An AssertTest of (2,3)" should "give value of x and y correctly" in {
    val v1 = AssertTest(2, 3)
    v1.x should be(2)
    v1.y should be(3)
  }

  it should "throw an asserttion Exception if x > y is tried" in {
    a[AssertionError] should be thrownBy {
      AssertTest(4, 3)
    }
  }

  "An Some" should "return value for get" in {
    val sm: Option[String] = Some("Hello Option")
    sm.isDefined should be(true)
    sm should be(Some("Hello Option"))
    sm.get should be("Hello Option")
  }

  "A None" should "throw exception on get" in {
    val non: Option[String] = None
    non.isDefined should be(false)
    a[NoSuchElementException] should be thrownBy {
      non.get
    }

  }

  "An Optn's maybeItWillReturnSomething method" should " return something" in {
    val value1 = Optn.maybeItWillReturnSomething(true)
    value1 should be(Some("Found Value"))

    val value2 = Optn.maybeItWillReturnSomething(false)
    value2 should be(None)

    value1 getOrElse "Default" should be("Found Value")
    value2 getOrElse "Default" should be("Default")

    value2 getOrElse "Default2" should be("Default2")

    value1.isEmpty should be(false)
    value2.isEmpty should be(true)
    value1.isDefined should be(true)
    value2.isDefined should be(false)

  }

  "Optional values" should "do these " in {
    val num: Option[Int] = Some(3)
    val noNum: Option[Int] = None

    val result1 = num match {
      case Some(v) => v
      case None => -1
    }

    val result2 = noNum match {
      case Some(v) => v
      case None => -1
    }
    
    result1 should be (3)
    result2 should be (-1)
    
    val r1 = num.map(_ * 2)
    r1.get should be (6)
    
    val r2 = noNum.map(_ * 2)
    
    r2.isDefined should be (false)
    
    a [NoSuchElementException] should be thrownBy(r2.get)

  }

}