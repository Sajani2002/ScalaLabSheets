object Square extends App{
    def calculateSquare(numbers: List[Int]): List[Int] = {
        numbers.map(num => num*num)
    }

    val inputList2 = List(1,2,3,4,5)
    val squareNumbers = calculateSquare(inputList2)
    println(squareNumbers)

}