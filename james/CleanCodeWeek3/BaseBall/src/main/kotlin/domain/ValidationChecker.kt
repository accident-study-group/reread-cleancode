package domain

class ValidationChecker {
    fun isInteger(number: String?): Boolean {
        return try {
            number?.toInt()
            true
        } catch (error: NumberFormatException) {
            false
        }
    }

    fun isValidInputNumber(number: String?): Boolean {
        if (number?.length!! > 3) {
            return false
        }
        val number1 = (number?.substring(0, 1)?.toInt()!! in 1..9)
        val number2 = (number?.substring(1, 2)?.toInt()!! in 1..9)
        val number3 = (number?.substring(2, 3)?.toInt()!! in 1..9)
        return number1 && number2 && number3
    }

    fun isValidRetryOrQuit(number: String?): Boolean {
        return (number == "1" || number == "2")
    }
}