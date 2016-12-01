

package mraditya.aperiodic.net

import tests.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P01TestSuite extends UnitSpec {
  
  "Solution for P01" should "return last of a lsit" in {
    val list = List(1,2,3)
    val last = P01.last(list)
    last.isDefined should be (true)
    last.get should be (3) 
  }

}