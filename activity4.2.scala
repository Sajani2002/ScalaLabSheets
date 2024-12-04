object PatternMatching{
    def main(args: Array[String]): Unit ={
        println("Enter an integer: ")
        val num = scala.io.StdIn.readLine().toInt

        num match{
            case n if n<= 0 => println("Negative/ Zero is input")
            case n if n%2 == 0 => println("Even number is given")
            case _ => println("Odd number is given")
        }
    }
}