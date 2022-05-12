object Vector2Test extends Assert {
  def main(args: Array[String]): Unit = {
    import slm._;
    import scala.math._;

    val v1 = Vector2(1, 2);
    assert(v1.x == 1 && v1.y == 2);

    val v2 = Vector2(2, 3) + v1;
    assert(v2.r == 3 && v2.y == 5);

    val v3 = Vector2(3, 1);
    val d = v1 dot v3;
    assert(d == 5);

    val v4 = Vector2(3, 4);
    assert(v4.length == 5 && v4.length2 == 25);

    val v5 = v4.normalized;
    assert(abs(v5.x - 0.6f) < 0.0001 && abs(v5.y - 0.8f) < 0.0001f);

    val v6 = Vector2.left * 2;
    assert(v6.x == -2 && v6.y == 0);

    println("OK");
  }
}
