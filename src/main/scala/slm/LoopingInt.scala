package slm

import base._

class LoopingInt extends Looping[Int] {
  override def forLoop[StateExpr](s: StateExpr)(len: Int)(f: (StateExpr, Int) => StateExpr): StateExpr = (0 until len).foldLeft(s)(f)
}
