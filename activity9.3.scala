object StringFormatter {

  def toUpper(str: String): String = str.toUpperCase

  def toLower(str: String): String = str.toLowerCase

  def formatNames(name: String)(formatFunction: String => String): String = formatFunction(name)

  def main(args: Array[String]): Unit = {

    val name1 = formatNames("Benny")(toUpper)
    val name2 = formatNames("Niroshan")(name => name.substring(0, 2).toUpperCase + name.substring(2).toLowerCase)
    val name3 = formatNames("Saman")(toLower)
    val name4 = formatNames("Kumara")(name => name.substring(0, 1).toUpperCase + name.substring(1, name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase)

    println(name1)  
    println(name2) 
    println(name3)
    println(name4)  
  }
}
