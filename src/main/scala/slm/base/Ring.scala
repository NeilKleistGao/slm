package slm.base

trait Ring[Expr] extends SemiRing[Expr] {
  def neg(expr: Expr): Expr
  def sub(lhs: Expr, rhs: Expr): Expr = add(lhs, neg(rhs))
}
