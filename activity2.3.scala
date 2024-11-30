object expression3{
    def main(args: Array[String]):Unit = {
        println(s"For normal working hours: Rs. ${wage(40)}")
        println(s"For OT hours: Rs. ${OT(30)}")
        val grossSalary = income(40,30)
        println(s"Income: Rs. $grossSalary")
        val taxAmount = tax(grossSalary)
        println(s"Tax: Rs. $taxAmount")
        val takeHomeSalary = takeHome(grossSalary,taxAmount)
        println(s"Take home amount: Rs. $takeHomeSalary")

    }

    def wage(h1:Int)= h1*250

    def OT(h2:Int)= h2*85

    def income(h1:Int,h2:Int)= wage(h1) + OT(h2)

    def tax(income:Int)= income*12/100

    def takeHome(income:Int,tax:Int)= income - tax
}