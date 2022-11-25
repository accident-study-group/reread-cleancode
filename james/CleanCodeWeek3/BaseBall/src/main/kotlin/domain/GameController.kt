package domain

import view.InputView
import view.OutputView

const val REPLAY = 1

class GameController {
    private val gameBoardMaker = GameBoardMaker()
    private var gameBoardData = gameBoardMaker.makeBoardData()
    private val outputView = OutputView()

    fun startGame() {
        do {
            play()
        } while (isReplayable())

    }

    private fun play() {
        val inputView = InputView()
        var inputNumber: String?
        var calculator = Calculator()

        while (isPlayable()) {
            println("data : ${gameBoardData.boardData}")
            resetGameState()
            inputNumber = inputView.getPlayerInput()
            gameBoardData = calculator.countGameState(gameBoardData, inputNumber)
            outputView.printResult(calculator.makeResultState(gameBoardData))
        }
    }

    private fun isReplayable(): Boolean {
        outputView.printEnd()
        if (outputView.getReplayOrQuit() == REPLAY) {
            gameBoardData = gameBoardMaker.makeBoardData()
            return true
        }
        return false
    }

    private fun isPlayable(): Boolean {
        return gameBoardData.strike != 3
    }

    private fun resetGameState() {
        gameBoardData.strike = 0
        gameBoardData.ball = 0
    }
}
