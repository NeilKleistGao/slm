package slm

import base._

object RingFloat extends Ring[Float] {
  override def neg(expr: Float): Float = -expr

  override def add(lhs: Float, rhs: Float): Float = lhs + rhs

  override def mul(lhs: Float, rhs: Float): Float = lhs * rhs

  override def one: Float = 1.0f

  override def zero: Float = 0.0f
}
