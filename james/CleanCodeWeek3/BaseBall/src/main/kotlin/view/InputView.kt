package view

import domain.ValidationChecker

class InputView {
    fun getPlayerInput(): String? {
        print("숫자를 입력해주세요 : ")
        val number: String? = readLine()
        if (ValidationChecker().isValidInputNumber(number) && ValidationChecker().isInteger(number)) {
            return number
        } else {
            throw IllegalArgumentException()
        }
    }
}