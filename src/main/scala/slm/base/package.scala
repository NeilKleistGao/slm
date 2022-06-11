package slm

package object base {
  def add[Expr](lhs: Expr, rhs: Expr)(implicit env: SemiRing[Expr]): Expr = env.add(lhs, rhs)
  def mul[Expr](lhs: Expr, rhs: Expr)(implicit env: SemiRing[Expr]): Expr = env.mul(lhs, rhs)
  def one[Expr](implicit env: SemiRing[Expr]): Expr = env.one
  def zero[Expr](implicit env: SemiRing[Expr]): Expr = env.zero

  def neg[Expr](expr: Expr)(implicit env: Ring[Expr]): Expr = env.neg(expr)
  def sub[Expr](lhs: Expr, rhs: Expr)(implicit env: Ring[Expr]): Expr = env.sub(lhs, rhs)

  def dim[VectorExpr, DimExpr](vec: VectorExpr)(implicit env: Module[VectorExpr, _, DimExpr]): DimExpr = env.dim(vec)
  def add[VectorExpr](lhs: VectorExpr, rhs: VectorExpr)(implicit env: Module[VectorExpr, _, _]): VectorExpr = env.add(lhs, rhs)
  def smul[ScaleExpr, VectorExpr](s: ScaleExpr, v: VectorExpr)(implicit env: Module[VectorExpr, ScaleExpr, _]): VectorExpr = env.smul(s, v)

  def apply[MatrixExpr, VectorExpr](mat: MatrixExpr, vec: VectorExpr)(implicit env: LinearMap[MatrixExpr, VectorExpr, _, _]): VectorExpr = env.apply(mat, vec)
  def compose[MatrixExpr](lhs: MatrixExpr, rhs: MatrixExpr)(implicit env: LinearMap[MatrixExpr, _, _, _]): MatrixExpr = env.compose(lhs, rhs)
  def add[MatrixExpr](lhs: MatrixExpr, rhs: MatrixExpr)(implicit env: LinearMap[MatrixExpr, _, _, _]): MatrixExpr = env.add(lhs, rhs)
  def dims[MatrixExpr, DimExpr](mat: MatrixExpr)(implicit env: LinearMap[MatrixExpr, _, _, DimExpr]): (DimExpr, DimExpr) = env.dims(mat)

  def build[ArrExpr, EleExpr, LenExpr](len: LenExpr)(f: LenExpr => EleExpr)(implicit env: PullArrayOps[ArrExpr, EleExpr, LenExpr]): ArrExpr = env.build(len)(f)
  def get[ArrExpr, EleExpr, LenExpr](arr: ArrExpr)(i: LenExpr)(implicit env: PullArrayOps[ArrExpr, EleExpr, LenExpr]): EleExpr = env.get(arr)(i)
  def length[ArrExpr, LenExpr](arr: ArrExpr)(implicit env: PullArrayOps[ArrExpr, _, LenExpr]): LenExpr = env.length(arr)

  def forLoop[LenExpr, StateExpr](s: StateExpr)(len: LenExpr)(f: (StateExpr, LenExpr) => StateExpr)(implicit env: Looping[LenExpr]): StateExpr = env.forLoop[StateExpr](s)(len)(f)
}
