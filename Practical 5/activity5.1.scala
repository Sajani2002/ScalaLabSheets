import scala.io.StdIn.readLine

object InventoryManagement {

  def getProductList(): List[String] = {
    var products = List[String]()
    var input = ""
    println("Enter product names (type 'done' to finish):")
    while (input != "done") {
      input = readLine()
      if (input != "done") {
        products = products :+ input
      }
    }
    products
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.length
  }

  def main(args: Array[String]): Unit = {
    val products = getProductList()
    println("\nProduct List:")
    printProductList(products)
    val total = getTotalProducts(products)
    println(s"\nTotal number of products: $total")
  }
}
