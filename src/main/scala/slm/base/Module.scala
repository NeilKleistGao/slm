package slm.base

trait Module[VectorExpr, ScaleExpr, DimExpr] {
  implicit val scala_semi_ring: SemiRing[ScaleExpr]
  implicit val vector_semi_ring: SemiRing[VectorExpr]

  def dim(v: VectorExpr): DimExpr
  def add(lhs: VectorExpr, rhs: VectorExpr): VectorExpr
  def smul(s: ScaleExpr, v: VectorExpr): VectorExpr
}