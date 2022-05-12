package slm

class Vector2 (p_x : Float, p_y : Float) {
  import scala.math._;
  private val m_arr = Array(p_x, p_y);

  val x: Float = m_arr(0);
  val y: Float = m_arr(1);

  val r: Float = x;
  val g: Float = y;

  val length2: Float = x * x + y * y;
  val length: Float = sqrt(length2).toFloat;
  lazy val normalized: Vector2 = if (length < 0.00001) throw new Exception() else Vector2(x, y) * (1 / length);;

  def +(p_other: Vector2): Vector2 = Vector2(x + p_other.x, y + p_other.y);
  def -(p_other: Vector2): Vector2 = Vector2(x + p_other.x, y + p_other.y);
  def *(p_other: Float): Vector2 = Vector2(x * p_other, y * p_other);

  def dot(p_other: Vector2): Float = x * p_other.x + y * p_other.y;
}

object Vector2 {
  def apply(p_x : Float = 0.0f, p_y: Float = 0.0f): Vector2 = new Vector2(p_x, p_y);

  val up: Vector2 = Vector2(0, 1);
  val down: Vector2 = Vector2(0, -1);
  val left: Vector2 = Vector2(-1);
  val right: Vector2 = Vector2(1);
  val zero: Vector2 = Vector2();
}
