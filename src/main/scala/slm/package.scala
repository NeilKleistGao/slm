package object slm {
  def toString[T](expr: T)(implicit env: Printable[T]): String = env.toString(expr)
}
