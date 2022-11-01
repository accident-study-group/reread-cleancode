package view

import domain.InputNumber

class InputView {
    fun getPlayerInput(): String? {
        print("숫자를 입력해주세요 : ")
        val number = InputNumber(readLine())
        return number.number
    }
}
