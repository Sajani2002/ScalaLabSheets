object roundedAvg{
    def main(args: Array[String]): Unit = {
        val num1 = 5
        val num2 = 6
        val mean = average(num1,num2)
        println(f"$mean%.2f")
    }

    def average(num1: Int, num2: Int): Double={
        (num1 + num2)/2.0
    }
}