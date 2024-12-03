object stringfilter{
    def main(args: Array[String]):Unit={
        println("Enter a list of strings : ")
        val stringsList = readStrings()
        val longString = filter(stringsList)
        println("Strings with length greater than 5: ")
        longString.foreach(println)
    }

    def readStrings(): List[String] = {
        Iterator.continually(scala.io.StdIn.readLine())
        .takeWhile(_ != "END")
        .toList
    }

    def filter(strings: List[String]):List[String]={
        strings.filter(_.length > 5)
    }
}