package slm.base

trait Looping[LenExpr] {
  def forLoop[StateExpr](s: StateExpr)(len: LenExpr)(f: (StateExpr, LenExpr) => StateExpr): StateExpr
}
