package slm

import slm.base._;

object SLM {
  def add[Expr](lhs: Expr, rhs: Expr)(implicit env: SemiRing[Expr]): Expr = env.add(lhs, rhs)
  def mul[Expr](lhs: Expr, rhs: Expr)(implicit env: SemiRing[Expr]): Expr = env.mul(lhs, rhs)
  def one[Expr](implicit env: SemiRing[Expr]): Expr = env.one
  def zero[Expr](implicit env: SemiRing[Expr]): Expr = env.zero

  def neg[Expr](expr: Expr)(implicit env: Ring[Expr]): Expr = env.neg(expr)
  def sub[Expr](lhs: Expr, rhs: Expr)(implicit env: Ring[Expr]): Expr = env.sub(lhs, rhs)

  def dim[VectorExpr, DimExpr](vec: VectorExpr)(implicit env: Module[VectorExpr, _, DimExpr]): DimExpr = env.dim(vec)
}
