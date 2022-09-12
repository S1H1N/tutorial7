object question3 {
    val find = (a:Int, b:List[Account]) => b.filter(account => account.accId.equals(a))
    var accountList:List[Account] = List()
    def main(args: Array[String]): Unit = {
      //var accountList:List[Account] = List()

      def createAcc(nic:String, accId: Int):Unit = {
        val acc = new Account(nic, accId)
        accountList = accountList ::: acc :: Nil
        println(accountList)
      }

      //val find = (a:Int, b:List[Account]) => b.filter(account => account.accId.equals(a))

      /*              Driver Code                */

      createAcc("1",1)
      createAcc("2",2)

      find(1, accountList).head.deposit(1000)  //deposit money
      println(find(1, accountList).head)

      find(1, accountList).head.transfer(2, 100.0)  //transfer money
      println(find(2, accountList).head)
    }

  class Account(nic:String, val accId: Int, var balance: Double = 0.0){

    def withdraw(amount:Double) : Unit = {
      this.balance = this.balance - amount
    }

    def deposit(amount:Double) : Unit = {
      this.balance = this.balance + amount
    }

    def transfer(account:Int, amount:Double) : Unit = {
      val transferAcc = find(account, accountList)
      if (balance < 0.0) println("Insufficient balance")
      else {
        this.withdraw(amount)
        transferAcc.head.deposit(amount)
      }
    }

    override def toString: String = "["+nic+":"+accId +":"+ balance+"]"
  }

}


