class Assert {
  def assert(state: Boolean): Unit = {
    if (!state) {
      throw new Exception();
    }
  }
}
