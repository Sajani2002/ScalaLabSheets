object Volume{
    def volume(radius: Double): Double = {
        val pi = Math.PI
        (4/3)*pi*radius*radius*radius
    }

    def main(args: Array[String]): Unit = {
        val radius = 5
        val vol = volume(radius)
        println(s"Volume = $vol")
    }
}