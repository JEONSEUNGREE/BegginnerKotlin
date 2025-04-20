package kr.tutorial.myfirstapp.basic.section4
//
//접근 제어자	접근 가능 범위
//public	어디서나 접근 가능 (기본값)
//internal	같은 모듈 내에서만 접근 가능
//protected	자식 클래스에서만 접근 가능
//private	같은 클래스 내에서만 접근 가능

fun main() {

    val bnkAct = BankAccount("tory", 5000000.0)

    println(bnkAct.accountHolder)
    bnkAct.deposit(500.0)
    bnkAct.deposit(600.0)
    bnkAct.displayTransactionHistory()
    println(bnkAct.balance)

}

class BankAccount(
    val accountHolder : String,
    var balance : Double
) {

    private val transactionHistory = mutableListOf<Double>()

    fun deposit(amount: Double) {
        balance = balance.plus(amount)
        transactionHistory.add(amount)
    }

    fun displayTransactionHistory() {
        println(transactionHistory)
    }


}