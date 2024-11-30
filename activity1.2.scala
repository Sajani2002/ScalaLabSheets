object FarenheitConverter {
  def temp(celcius: Double): Double = {
    celcius*1.8000 + 32.00
  }

  def main(args: Array[String]): Unit = {
    val celcius = 35
    val faren = temp(celcius)
    println(s"Temperature in Farenheit = $faren")
  }
}
