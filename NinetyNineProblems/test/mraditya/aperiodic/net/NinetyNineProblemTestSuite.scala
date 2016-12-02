

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
  
  "Solution for P02" should "return second last of a lsit" in {
    val list = List(1,2,3,4)
    val penultimate = P01.penultimate(list)
    penultimate.isDefined should be (true)
    penultimate.get should be (3) 
    val noPenultimate = P01.penultimate(List(1))
    noPenultimate.isDefined should be (false)
  }
  
  "LastNth" should "return " in {
    val list = List(1,2,3,4,5)
    P01.lastNth(1, list).get should be(5)
    P01.lastNth(2, list).get should be(4)
    P01.lastNth(3, list).get should be(3)
    P01.lastNth(4, list).get should be(2)
    P01.lastNth(5, list).get should be(1)
    P01.lastNth(6, list).isDefined should be(false)
  }
  
  "Nth of List" should "work" in {
    val list = List(0,1,2,3,4,5)
    
    for ( i <- 0 to 5) {
      P01.nth(i, list).get should be (i)
    }
    a [NoSuchElementException] should be thrownBy{P01.nth(6, list).get}
  }
  
  "NthRecursive of List" should "work" in {
    val list = List(0,1,2,3,4,5)
    
    for ( i <- 0 to 5) {
      P01.nthRecursive(i, list).get should be (i)
    }
    a [NoSuchElementException] should be thrownBy{P01.nth(6, list).get}
  }

}