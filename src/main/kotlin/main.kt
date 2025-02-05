package ru.netology

fun main () {
    val result = commissionCard("Mastercard", 80000, 30000)

    when (result){
        -1 -> println("Операция заблокирована. Превышен дневной лимит!")
        -2 -> println("Операция заблокирована. Превышен месячный лимит!")
        else -> println("Комиссия за перевод составит $result рублей.")
    }


}

fun commissionCard(typeCard: String = "Мир", sumMonthTransfer: Int = 0, transfer: Int,
                   dailyLimit: Int = 150_000, monthLimit: Int = 600_000): Int {
    if (transfer > dailyLimit) return -1
    if (transfer + sumMonthTransfer > monthLimit) return -2
    return when (typeCard) {
       "Мир" -> 0
       "Visa" -> {
           val result = (transfer * 0.0075).toInt()
           if (result < 35) 35 else result
       }
       "Mastercard" -> {
           val upLimit = if (sumMonthTransfer > 75000) transfer else sumMonthTransfer + transfer - 75000
           if (upLimit <= 0) 0 else (upLimit * 0.006 + 20).toInt()
       }
       else -> -1
    }
}
