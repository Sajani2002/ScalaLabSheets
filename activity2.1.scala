object expression1{
    def main(args: Array[String]):Unit = {
        var k,i,j = 2
        var m,n = 5
        var f = 12.0f
        var g = 4.0f
        var c = 'X'

        var A = k + 12*m
        var B = m/j
        var C = n%j
        var D = m/j*j
        var E = f + 10*5 +g
        var F = (i+1) * n

        println(s"$A")
        println(s"$B")
        println(s"$C")
        println(s"$D")
        println(s"$E")
        println(s"$F")
    }
}