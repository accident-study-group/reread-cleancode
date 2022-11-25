package view

import domain.ValidationChecker

class OutputView {
    fun printResult(resultState: String) {
        var ball = resultState.substring(0, 1).toInt()
        val strike = resultState.substring(1, 2).toInt()

        if (ball > 0) {
            println("${ball}볼")
        }
        if (strike > 0) {
            println("${strike}스트라이크")
        }
        if (ball == 0 && strike == 0) {
            println("낫싱")
        }
    }

    fun printEnd() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
    }

    fun getReplayOrQuit(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val number: String? = readLine()
        // TODO: 원시값 포장하기
        if (ValidationChecker().isValidReplayOrQuit(number) && ValidationChecker().isInteger(number)) {
            return number?.toInt()!!
        }

        throw IllegalArgumentException()
    }
}
