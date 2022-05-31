package slm.base

trait LinearMap[MatrixExpr, VectorExpr, ScalaExpr, DimExpr] {
  implicit val col_vector_module: Module[VectorExpr, ScalaExpr, DimExpr]
  implicit val scale_semi_ring: SemiRing[ScalaExpr]
  implicit val vector_semi_ring: SemiRing[VectorExpr]

  def apply(mat: MatrixExpr, vec: VectorExpr): VectorExpr
  def compose(lhs: MatrixExpr, rhs: MatrixExpr): MatrixExpr
  def add(lhs: MatrixExpr, rhs: MatrixExpr): MatrixExpr
  def dims(mat: MatrixExpr): (DimExpr, DimExpr)
}
