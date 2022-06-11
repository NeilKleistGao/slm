package slm

import matrix.Vector
import slm.base.{Looping, PullArrayOps, SemiRing}

class VectorFloat extends Vector[Array[Float], Float, Int] {
  override implicit val ops: PullArrayOps[Array[Float], Float, Int] = new PullArrayArrayOps[Float]
  override implicit val looping: Looping[Int] = new LoopingInt
  override implicit val scale_semi_ring: SemiRing[Float] = RingFloat
}
