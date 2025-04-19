package kr.tutorial.myfirstapp.basic.section2

fun main() {

    // 콘솔입력받기 자바의 new Scanner(System.in)
//    println("Please enter your age as a whole number")
//    val enteredValue = readln().toInt()
//
//    if (enteredValue >= 18) {
//        println("adult")
//    } else {
//        println("junior")
//    }
//
    var computerChoice = ""
    var playerChoice = ""
    val rock = "Rock"
    val scissors = "Scissors"
    val paper = "Paper"
    val draw = "Draw"
    val player = "Player"
    val computer = "Computer"
    // if문
//    if (randomNumber == 1) {
//        computerChoice = "Rock"
//    }else if (randomNumber == 2) {
//        computerChoice = "Scissors"
//    }else if (randomNumber == 3) {
//        computerChoice = "Paper"
//    }


    println("Rock, Scissors, Paper? enter your Choice!")

    playerChoice = readln().replaceFirstChar { it.uppercase() }
//    val formatted = readln()
//        .split("")
//        .filter { it.isNotEmpty() }              // split("") 하면 맨 앞이 빈 문자열 생겨서 필터링 필요
//        .mapIndexed { index, c ->
//            if (index == 0) c.uppercase() else c.lowercase()
//        }
//        .joinToString("") + " 선택됨"


    val randomNumber = (1..3).random()

    // case문
    when (randomNumber) {
        1 -> {
            computerChoice = rock
        }

        2 -> {
            computerChoice = scissors
        }

        3 -> {
            computerChoice = paper
        }
    }

    val winner = when {
        playerChoice == computerChoice -> draw
        playerChoice == rock && computerChoice == scissors -> player
        playerChoice == scissors && computerChoice == paper -> player
        playerChoice == paper && computerChoice == rock -> player
        else -> computer
    }


    println("Computer Choice $computerChoice")
    println("Your Choice $playerChoice")
    println("Winner is $winner")
}
