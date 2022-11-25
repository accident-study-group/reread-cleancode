package domain

class InputNumber(val number: String?) {
    init {
        if (!(ValidationChecker().isValidInputNumber(number) && ValidationChecker().isInteger(number))) {
            throw IllegalArgumentException()
        }
    }
}
