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
        var number = Random().nextInt(8) + 1
        if (!isDuplicate(number)) {
            gameBoardData.boardData.add(number.toString())
        }
    }

    private fun isDuplicate(number: Int): Boolean {
        return gameBoardData.boardData.contains(number.toString())
    }
}