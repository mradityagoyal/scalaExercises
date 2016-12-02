package mraditya.design.patterns

abstract class Connector {
  def connect()
  def close()
}

trait ConnectorWithHelper extends Connector {
  def findDriver(): Unit = {
    println("Find Driver Called")
  }
}

class OracleConnector extends ConnectorWithHelper {
  
  override def connect() = {
    println("connected to oracle DB")
  }
  
  override def close() = {
    println("disconnect from oracle DB")
  }
  
}