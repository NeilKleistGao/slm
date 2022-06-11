package slm.matrix

import slm.base._

trait Vector[VectorExpr, ScaleExpr, DimExpr] extends Module[VectorExpr, ScaleExpr, DimExpr] {
  implicit val ops: PullArrayOps[VectorExpr, ScaleExpr, DimExpr]
  implicit val looping: Looping[DimExpr]

  def dim(arr: VectorExpr): DimExpr = ops.length(arr)

  def map(v: VectorExpr, op: ScaleExpr => ScaleExpr): VectorExpr = ops.build(ops.length(v))(i => op(ops.get(v)(i)))
  def zipMap(v1: VectorExpr, v2: VectorExpr, op: (ScaleExpr, ScaleExpr) => ScaleExpr): VectorExpr =
    ops.build(ops.length(v1))(i => op(ops.get(v1)(i), ops.get(v2)(i)))

  def add(lhs: VectorExpr, rhs: VectorExpr) = zipMap(lhs, rhs, scale_semi_ring.add)
  def smul(s: ScaleExpr, v: VectorExpr): VectorExpr = map(v, e => scale_semi_ring.mul(s, e))
  def dot(lhs: VectorExpr, rhs: VectorExpr): ScaleExpr =
    looping.forLoop(scale_semi_ring.zero)(ops.length(lhs))((acc, i) =>
      scale_semi_ring.add(acc, scale_semi_ring.mul(ops.get(lhs)(i), ops.get(rhs)(i))))

  def zero(d: DimExpr): VectorExpr = ops.build(d)(_ => scale_semi_ring.zero)
}
