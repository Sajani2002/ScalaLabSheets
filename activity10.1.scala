class Rational_1(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(n.abs, d.abs)

  val numerator: Int = n / g
  val denominator: Int = d / g

  def neg: Rational_1 = new Rational_1(-numerator, denominator)

  override def toString: String = if (denominator == 1) s"$numerator" else s"$numerator/$denominator"
}

object Main_1 {
  def main(args: Array[String]): Unit = {
    val r1 = new Rational_1(5, 8)
    
    val negR1 = r1.neg
    
    println(s"Original Rational number: $r1")   
    println(s"Negated Rational number: $negR1") 
  }
}

