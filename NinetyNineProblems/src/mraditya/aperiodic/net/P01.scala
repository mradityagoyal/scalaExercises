package mraditya.aperiodic.net

object P01 {
  
  def last[A](list : List[A]): Option[A] = list match {
    case (x :: Nil) => Some(x)   
    case (_ :: tail) => last(tail)
    case Nil => None
  }
}