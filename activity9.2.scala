object PatternMatchingExample extends App {
  val checkNumber: Int => String = {
    case x if x <= 0 => "Negative/Zero is input"
    case x if x % 2 == 0 => "Even number is given"
    case x => "Odd number is given"
  }

  println("Please enter an integer:")
  val input = scala.io.StdIn.readLine()

  val result = try {
    val number = input.toInt
    checkNumber(number)
  } catch {
    case _: NumberFormatException => "Invalid input. Please enter a valid integer."
  }
  println(result)
}
