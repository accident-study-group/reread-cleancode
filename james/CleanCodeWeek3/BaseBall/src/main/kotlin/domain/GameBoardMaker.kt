package domain

import model.GameBoardData
import java.util.*
import kotlin.collections.ArrayList

class GameBoardMaker {
    private lateinit var gameBoardData : GameBoardData
    fun makeBoardData(): GameBoardData {
        gameBoardData = GameBoardData()
        gameBoardData.boardData = ArrayList()
        while (isContinuable()) {
            setGameBoardData()
        }
        return gameBoardData
    }

    private fun isContinuable(): Boolean {
        return gameBoardData.boardData.size < 3
    }

    private fun setGameBoardData() {
        var number = (Random().nextInt(9) + 1).toString()
        if (!isDuplicate(number)) {
            gameBoardData.boardData.add(number)
        }
    }

    private fun isDuplicate(number: String): Boolean {
        return gameBoardData.boardData.contains(number)
    }
}
