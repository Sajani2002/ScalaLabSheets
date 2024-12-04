import scala.io.StdIn.readLine

object InventorySystem extends App {

  val inventory1: Map[Int, (String, Int, Double)] = Map(
    101 -> ("Laptop", 10, 220000.00),
    102 -> ("Smartphone", 20, 39900.00),
    103 -> ("Tablet", 15, 40000.00)
  )

  val inventory2: Map[Int, (String, Int, Double)] = Map(
    102 -> ("Smartphone", 5, 54900.00), 
    104 -> ("Monitor", 8, 7950.00)
  )

  // Retrieve all product names from inventory1
  def retrieveProductNames(): Unit = {
    val productNames: Set[String] = inventory1.values.map(_._1).toSet
    println("Product Names: " + productNames.mkString(", "))
  }

  // Calculate the total value of all products in inventory1
  def calculateTotalValue(): Unit = {
    val totalValue: Double = inventory1.values.map { case (_, quantity, price) => quantity * price }.sum
    println("Total Value: " + totalValue)
  }

  // Check if inventory1 is empty
  def checkIfEmpty(): Unit = {
    val isEmpty: Boolean = inventory1.isEmpty
    println("Is Inventory1 Empty? " + isEmpty)
  }

  // Merge inventory1 and inventory2, updating quantities and retaining the highest price
  def mergeInventories(): Unit = {
    val mergedInventory: Map[Int, (String, Int, Double)] = (inventory1.toSeq ++ inventory2.toSeq)
      .groupBy(_._1)
      .map { case (id, products) =>
        val (name, totalQuantity, maxPrice) = products.map(_._2).reduce {
          case ((name1, quantity1, price1), (_, quantity2, price2)) =>
            (name1, quantity1 + quantity2, math.max(price1, price2))
        }
        id -> (name, totalQuantity, maxPrice)
      }

    println("Merged Inventory: " + mergedInventory.map { case (id, (name, quantity, price)) => s"$id -> ($name, $quantity, $price)" }.mkString(", "))
  }

  // Check if a product with a specific ID exists and print its details
  def checkProductById(productId: Int): Unit = {
    inventory1.get(productId) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID $productId exists: Name = $name, Quantity = $quantity, Price = $price")
      case None =>
        println(s"Product ID $productId does not exist in inventory1")
    }
  }

  def showMenu(): Unit = {
    println(
      """
        |Select an operation:
        |1. Retrieve all product names from inventory1
        |2. Calculate the total value of all products in inventory1
        |3. Check if inventory1 is empty
        |4. Merge inventory1 and inventory2
        |5. Check if a product with a specific ID exists
        |6. Exit
      """.stripMargin)
  }

  var continue = true

  while (continue) {
    showMenu()
    val choice = readLine("Enter your choice: ").toInt

    choice match {
      case 1 => retrieveProductNames()
      case 2 => calculateTotalValue()
      case 3 => checkIfEmpty()
      case 4 => mergeInventories()
      case 5 =>
        val productId = readLine("Enter the product ID: ").toInt
        checkProductById(productId)
      case 6 =>
        continue = false
        println("Exiting...")
      case _ => println("Invalid choice. Please select a valid option.")
    }
  }
}

