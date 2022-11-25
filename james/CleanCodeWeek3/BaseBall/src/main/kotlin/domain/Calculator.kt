package domain

import model.GameBoardData

class Calculator {
    fun countGameState(gameBoardData: GameBoardData, inputData: String?): GameBoardData {
        for (i: Int in 0 until gameBoardData.boardData.size) {
            iterateInputData(gameBoardData, inputData, i)
        }
        return gameBoardData
    }

    private fun iterateInputData(gameBoardData: GameBoardData, inputData: String?, i :Int) {
        for (j: Int in 0 until inputData?.length!!) {
            checkEqualNumber(gameBoardData, inputData, i, j)
        }
    }

    private fun checkEqualNumber(gameBoardData: GameBoardData, inputData: String?, i :Int, j: Int) {
        if (gameBoardData.boardData[i] == inputData?.substring(j, j + 1)) {
            if (i == j) {
                gameBoardData.strike++
            } else {
                gameBoardData.ball++
            }
        }
    }

    fun makeResultState(gameBoard: GameBoardData): String {
        return "${gameBoard.ball}${gameBoard.strike}"
    }
}
