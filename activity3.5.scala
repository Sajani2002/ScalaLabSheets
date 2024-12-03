object sumofEven{
    def main(args: Array[String]): Unit = {
        val num = List(3, 4, 5, 6, 7)
        val sumEvens = sumList(num)
        println(sumEvens)
    }

    def sumList(num: List[Int]):Int = {
        num.filter(_ % 2 == 0).sum
    }
}