package mraditya.design.patterns.chapter4

class AbstractTypes {
  
}

trait ContainerAT {
  type T
  val data: T
  
  def compare(other: T): Boolean = data.equals(other)
}

class StringContainer(val data: String) extends ContainerAT{
  override type T = String
}