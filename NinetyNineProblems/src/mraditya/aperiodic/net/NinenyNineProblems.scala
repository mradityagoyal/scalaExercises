package mraditya.aperiodic.net

object P01 {

  /*
   * Find the last element of a list.
   * Example:
   * scala> last(List(1, 1, 2, 3, 5, 8))
   * res0: Int = 8
   */
  def last[A](list: List[A]): Option[A] = list match {
    case (x :: Nil) => Some(x)
    case (_ :: tail) => last(tail)
    case Nil => None
  }

  /**
   * Find the last but one element of a list.
   */
  def penultimate[A](list: List[A]): Option[A] = list match {
    case x :: _ :: Nil => Some(x)
    case _ :: tail => penultimate(tail)
    case _ => None

  }

  /**
   * find last nth element of a list. 
   */
  def lastNth[A](n: Int, list: List[A]): Option[A] = {
    if (list.size < n) {
      None
    } else {
      Some(list.takeRight(n).head)
    }
  }
  
  /**
   * find Kth element of a list 
   */
  def nth[A](n: Int, list: List[A]): Option[A] = {
    if(n > list.length-1){
      None
    }else{
      Some(list(n))
    }
  }
  
  def nthRecursive[A](n: Int, ls: List[A]): Option[A] = (n, ls) match {
    case (0, h :: _ ) => Some(h)
    case (n, _ :: tail) => nthRecursive(n-1, tail)
    case (_ , Nil) => None
    
  }
  
  
}