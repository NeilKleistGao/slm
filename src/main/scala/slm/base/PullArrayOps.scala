package slm.base

trait PullArrayOps[ArrExpr, EleExpr, LenExpr] {
  def build(len: LenExpr)(f: LenExpr => EleExpr): ArrExpr
  def get(arr: ArrExpr)(i: LenExpr): EleExpr
  def length(arr: ArrExpr): LenExpr
}
