object WholesaleCost{
    def discount(copy: Int): Double = {
        24.95*copy*60/100
    }
    def shipping(copy: Int): Double = {
        if(copy<=50) 3*copy
        else (copy-50)*0.75 + 50*3
    }

    def main(args: Array[String]): Unit = {
        val copy = 60
        val cost = discount(copy) + shipping(copy)
        println(s"Total cost = Rs.$cost")
    }
}