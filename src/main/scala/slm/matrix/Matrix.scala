package slm.matrix

import slm.base._

trait Matrix[MatrixExpr, VectorExpr, ScaleExpr, DimExpr] extends LinearMap[MatrixExpr, VectorExpr, ScaleExpr, DimExpr] {
  implicit val mat_ops: PullArrayOps[MatrixExpr, VectorExpr, DimExpr]
  implicit val row_ops: PullArrayOps[VectorExpr, ScaleExpr, DimExpr]
  implicit val vector: Vector[VectorExpr, ScaleExpr, DimExpr]

  def rows(mat: MatrixExpr): DimExpr = dims(mat)._1
  def cols(mat: MatrixExpr): DimExpr = dims(mat)._2

  def get(mat: MatrixExpr, row: DimExpr, col: DimExpr): ScaleExpr =
    row_ops.get(mat_ops.get(mat)(row))(col)

  def getRow(mat: MatrixExpr, row: DimExpr): VectorExpr = mat_ops.get(mat)(row)
  def getCol(mat: MatrixExpr, col: DimExpr): VectorExpr = mat_ops.get(transpose(mat))(col)

  def transpose(mat: MatrixExpr): MatrixExpr =
    mat_ops.build(cols(mat))(i =>
      row_ops.build(rows(mat))(j => get(mat, j, i)))

  def map(mat: MatrixExpr, op: ScaleExpr => ScaleExpr): MatrixExpr =
    mat_ops.build(rows(mat))(i =>
      row_ops.build(cols(mat))(j => op(get(mat, i, j))))

  def zipMap(mat1: MatrixExpr, mat2: MatrixExpr, op: (ScaleExpr, ScaleExpr) => ScaleExpr): MatrixExpr =
    mat_ops.build(rows(mat1))(i =>
      row_ops.build(cols(mat1))(j => op(get(mat1, i, j), get(mat2, i, j))))

  def add(mat1: MatrixExpr, mat2: MatrixExpr): MatrixExpr = zipMap(mat1, mat2, scale_semi_ring.add)
  def mul(mat1: MatrixExpr, mat2: MatrixExpr): MatrixExpr =
    mat_ops.build(rows(mat1))(i =>
      row_ops.build(cols(mat2))(j => vector.dot(getRow(mat1, i), getCol(mat2, j))))

  def zero(row: DimExpr, col:DimExpr): MatrixExpr =
    mat_ops.build(row)(_ =>
      row_ops.build(col)(_ => scale_semi_ring.zero))

  def eye(d: DimExpr): MatrixExpr =
    mat_ops.build(d)(i =>
      row_ops.build(d)(j => if (i == j) scale_semi_ring.one else scale_semi_ring.zero))
}
