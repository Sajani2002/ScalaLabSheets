object RunningTime{
    def easy(distance: Int): Int = {
        8*distance
    }
    def tempo(distance: Int): Int = {
        7*distance
    }

    def main(args: Array[String]): Unit = {
        val distance1 = 2
        val distance2 = 3 
        val distance3 = 2
        val total = easy(distance1) + tempo(distance2) + easy(distance3)
        println(s"Total time = $total min")
    }
}