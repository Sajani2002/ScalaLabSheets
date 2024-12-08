class Account_2(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
  }

  def transfer(amount: Double, toAccount: Account_2): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 
    } else {
      balance += balance * 0.1 
    }
  }

  override def toString: String = s"Account Balance: ${balance}"
}

object Bank {
  def accountsWithNegativeBalances(accounts: List[Account_2]): List[Account_2] = {
    accounts.filter(_.balance < 0)
  }

  def sumOfAllBalances(accounts: List[Account_2]): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAll(accounts: List[Account_2]): List[Account_2] = {
    accounts.foreach(_.applyInterest())
    accounts
  }
}

object Main_4 {
  def main(args: Array[String]): Unit = {
    val account1 = new Account_2(1500)
    val account2 = new Account_2(-200)
    val account3 = new Account_2(3000)
    val account4 = new Account_2(-50)

    val bank = List(account1, account2, account3, account4)

    val negativeAccounts = Bank.accountsWithNegativeBalances(bank)
    println("Accounts with negative balances:")
    negativeAccounts.foreach(println)

    val totalBalance = Bank.sumOfAllBalances(bank)
    println(s"Total balance of all accounts: ${totalBalance}")

    Bank.applyInterestToAll(bank)
    println("Final balances after applying interest:")
    bank.foreach(println)
  }
}
