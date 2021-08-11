// Задача №1 - «Только что»
fun main() {
    val numberOfSeconds = 2462
    println("был(а) ${secondsToString(numberOfSeconds)}")
}

fun secondsToString(numberOfSeconds : Int) : String {
    val limitSec = 60
    val limitMin = 3600
    val limitHour = 86400
    val limitToday = 172800
    val limitYesterday = 259200
    return when {
        numberOfSeconds <= limitSec -> "только что"
        numberOfSeconds > limitSec && numberOfSeconds <= limitMin -> "${correctEndingMin(numberOfSeconds / 60)} назад"
        numberOfSeconds > limitMin && numberOfSeconds <= limitHour -> "${correctEndingHour(numberOfSeconds / 3600)} назад"
        numberOfSeconds > limitHour && numberOfSeconds <= limitToday -> "сегодня"
        numberOfSeconds > limitToday && numberOfSeconds <= limitYesterday -> "вчера"
        else -> "давно"
    }
}

fun correctEndingMin(numberOfMin : Int) : String {
    var lastDigit = numberOfMin % 10
    when (lastDigit) {
        1 -> return "$numberOfMin минуту"
        2, 3, 4 -> return "$numberOfMin минуты"
        else -> return "$numberOfMin минут"
    }
}

fun correctEndingHour(numberOfHour : Int) : String {
    var lastDigit = numberOfHour % 10
    when (lastDigit) {
        1 -> return "$numberOfHour час"
        2, 3, 4 -> return "$numberOfHour часа"
        else -> return "$numberOfHour часов"
    }
}