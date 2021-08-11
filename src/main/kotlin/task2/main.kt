//Задача №2 - Разная комиссия
package task2

fun main() {
    val amount = 52000 //сумма перевода в копейках
    val payType = PayType.Maestro
    val sumAmountOfMonth = 10000

    println("Комиссия: ${calculationCommis(payType, sumAmountOfMonth, amount)}")
}

enum class PayType {
    Vkpay, Mastercard, Maestro, Visa, Mir
}

fun calculationCommis(payType: PayType = PayType.Vkpay, sumAmount: Int = 0, amount: Int): Int {
    val percentVisa = 0.75
    val minimumVisa = 3500

    val minimumMaster = 30000
    val maximumMaster = 7500000
    val percentMaster = 0.6
    val constantMaster  = 2000

    return when {
        payType == PayType.Visa || payType == PayType.Mir -> if (amount * percentVisa / 100 > minimumVisa)
            (amount * percentVisa / 100).toInt() else minimumVisa
        (payType == PayType.Mastercard || payType == PayType.Maestro) && (sumAmount < minimumMaster || sumAmount > maximumMaster) ->
            (amount * percentMaster / 100).toInt() + constantMaster
        else -> 0
    }
}