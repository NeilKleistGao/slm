package slm

trait Printable[T] {
  def toString(expr: T): String
}
