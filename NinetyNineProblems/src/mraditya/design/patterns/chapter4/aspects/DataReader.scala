package mraditya.design.patterns.chapter4.aspects

import org.json4s.DefaultFormats
import org.json4s.StreamInput
import org.json4s._

trait DataReader {

  def readData(): List[Person]
  def readDataInefficiently(): List[Person]

}

