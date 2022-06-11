package slm

import scala.reflect.ClassTag
import base._

class PullArrayArrayOps[T: ClassTag] extends PullArrayOps[Array[T], T, Int] {
  override def build(len: Int)(f: Int => T): Array[T] = Array.tabulate(len)(f)

  override def get(arr: Array[T])(i: Int): T = arr(i)

  override def length(arr: Array[T]): Int = arr.length
}
