package mraditya.aperiodic.net

object P01 {

  def last[A](list: List[A]): Option[A] = list match {
    case (x :: Nil) => Some(x)
    case (_ :: tail) => last(tail)
    case Nil => None
  }

  def penultimate[A](list: List[A]): Option[A] = list match {
    case x :: _ :: Nil => Some(x)
    case _ :: tail => penultimate(tail)
    case _ => None

  }

  def lastNth[A](n: Int, list: List[A]): Option[A] = {
    if (list.size < n) {
      None
    } else {
      Some(list.takeRight(n).head)
    }

  }
}