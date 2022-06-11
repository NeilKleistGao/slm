package slm

import base._

object RingArrayFloat extends Ring[Array[Float]] {
  override def neg(expr: Array[Float]): Array[Float] = expr.map(v => -v)

  override def add(lhs: Array[Float], rhs: Array[Float]): Array[Float] = lhs.zip(rhs).map(p => p._1 + p._2)

  override def mul(lhs: Array[Float], rhs: Array[Float]): Array[Float] = lhs.zip(rhs).map(p => p._1 * p._2)

  override def one: Array[Float] = ???

  override def zero: Array[Float] = ???
}
