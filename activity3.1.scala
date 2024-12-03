object reverse{
    def main(args: Array[String]):Unit={
        println("Enter a string to reverse: ")
        val string = scala.io.StdIn.readLine()
        val reversed = reversedString(string)
        println(reversed)
    }

    def reversedString(s: String):String={
        if (s.isEmpty) ""
        else reversedString(s.tail) + s.head
    }
}