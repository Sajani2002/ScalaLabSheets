object stringsFilter{
    def main(args: Array[String]): Unit={
        val strings = List("apple", "banana", "mango", "strawberry", "grape")
        val longStrings = filterLongStrings(strings)
        println(longStrings)
    }

    def filterLongStrings(strings: List[String]): List[String] = {
        strings.filter(_.length > 5)
    }
}