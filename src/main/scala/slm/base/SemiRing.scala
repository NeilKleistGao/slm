package slm.base

trait SemiRing[Expr] {
  def add(lhs: Expr, rhs: Expr): Expr
  def mul(lhs: Expr, rhs: Expr): Expr
  def one: Expr
  def zero: Expr
}
