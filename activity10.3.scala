class Account_1(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount, new balance is $balance")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount, new balance is $balance")
    } else if (amount > balance) {
      println("Insufficient funds for withdrawal.")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  def transfer(amount: Double, toAccount: Account_1): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $amount to the given account, your new balance is $balance")
    } else if (amount > balance) {
      println("Insufficient funds for transfer.")
    } else {
      println("Transfer amount must be positive.")
    }
  }
}

object Main_3 {
  def main(args: Array[String]): Unit = {
    val account1 = new Account_1(1000)
    val account2 = new Account_1(500)

    account1.deposit(200)  
    account1.withdraw(150) 
    account1.transfer(300, account2)  

    println(s"Final balance of account1: ${account1.balance}")
    println(s"Final balance of account2: ${account2.balance}")
  }
}
