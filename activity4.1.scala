object InventoryManagement {
  var itemNames: Array[String] = Array("Apples", "Bananas", "Oranges")
  var itemQuantities: Array[Int] = Array(50, 30, 20)

  def displayInventory(): Unit = {
    println("Current Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
    } else {
      println(s"Item $itemName does not exist in the inventory.")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
      } else {
        println(s"Not enough quantity of $itemName to sell. Available quantity: ${itemQuantities(index)}")
      }
    } else {
      println(s"Item $itemName does not exist in the inventory.")
    }
  }

  // Main method to test the functions
  def main(args: Array[String]): Unit = {
    displayInventory()

    println("\nRestocking 20 Bananas")
    restockItem("Bananas", 20)
    displayInventory()

    println("\nSelling 10 Apples")
    sellItem("Apples", 10)
    displayInventory()

    println("\nTrying to sell 50 Oranges")
    sellItem("Oranges", 50)
    displayInventory()

    println("\nTrying to restock an item that does not exist")
    restockItem("Grapes", 30)
    displayInventory()
  }
}
