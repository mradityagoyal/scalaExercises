package mraditya.design.patterns

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import tests.UnitSpec

@RunWith(classOf[JUnitRunner])
class LeniarizationTestSuite extends UnitSpec {
  
  class DoubleMultiplierIdentityClass extends DoubleMultiplierIdentity 
  
  val instance = new DoubleMultiplierIdentityClass
  
  "DoubleMultiplierIdenity" should "return 2*1" in {
    instance.identity should be (2)
  }
  
  "A test for modifiedIdentities to test leanirization behavior" should "show leniarization in action" in {
    val ins1 = new ModifiedIdentity1
    val ins2 = new ModifiedIdentity2
    val ins3 = new ModifiedIdentity3
    val ins4 = new ModifiedIdentity4
    val ins5 = new ModifiedIdentity5
    val ins6 = new ModifiedIdentity6
    
    ins1.identity should be (6)
    ins2.identity should be (2)
    ins3.identity should be (6)
    ins4.identity should be (6)
    ins5.identity should be (6)
    ins6.identity should be (3)
  }
  
}