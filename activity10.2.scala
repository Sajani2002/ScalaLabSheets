class Rational_2(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(n.abs, d.abs)

  val numerator: Int = n / g
  val denominator: Int = d / g

  def neg: Rational_2 = new Rational_2(-numerator, denominator)

  def sub(that: Rational_2): Rational_2 = {
    val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
    val newDenominator = this.denominator * that.denominator
    new Rational_2(newNumerator, newDenominator)
  }

  override def toString: String = if (denominator == 1) s"$numerator" else s"$numerator/$denominator"
}

object Main_2 {
  def main(args: Array[String]): Unit = {
    val x = new Rational_2(3, 4)
    val y = new Rational_2(5, 8)
    val z = new Rational_2(2, 7)

    val xy = x.sub(y)
    
    val result = xy.sub(z)

    println(s"Result of x y - z: $result")
  }
}
