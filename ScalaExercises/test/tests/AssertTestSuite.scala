package tests

import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import asrt.AssertTest
import org.scalatest.FlatSpec
import org.scalatest.Matchers

@RunWith(classOf[JUnitRunner])
class AssertTestSuite extends FlatSpec with Matchers {

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

}