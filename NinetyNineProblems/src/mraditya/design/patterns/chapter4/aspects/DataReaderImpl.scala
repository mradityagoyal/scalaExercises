package mraditya.design.patterns.chapter4.aspects

import org.json4s.StreamInput
import org.json4s.DefaultFormats
import org.json4s._
import org.json4s.jackson.JsonMethods._

class DataReaderImpl extends DataReader {
  implicit val formats = DefaultFormats
  private def readUntimed(): List[Person] =
    parse(StreamInput(getClass.getResourceAsStream("/users.json"))).extract[List[Person]]

  override def readData(): List[Person] =
    readUntimed()

  override def readDataInefficiently(): List[Person] = {
    (1 to 10000).foreach {
      case num =>
        readUntimed()
    }
    readUntimed()
  }
}

trait LoggingDataReader extends DataReader{
  abstract override def readData(): List[Person] = {
    val startMillis = System.currentTimeMillis()
    val result = super.readData()
    val time = System.currentTimeMillis() - startMillis
    println(s"TimeTaken: $time millis")
    result
  }
  
  
  abstract override def readDataInefficiently(): List[Person]= {
    val startMillis = System.currentTimeMillis()
    val result = super.readDataInefficiently()
    val time = System.currentTimeMillis() - startMillis
    println(s"InEfficient TimeTaken: $time millis")
    result
  }
}

object DataRader {
  val impl = new DataReaderImpl with LoggingDataReader

  def main(args: Array[String]): Unit = {
    val persons = impl.readData()
    persons.foreach(println(_))
    val ineffPersons = impl.readDataInefficiently()
    ineffPersons.foreach(println(_))
  }
}