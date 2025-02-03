package ru.netology

fun main () {
    val result = commissionCard("Mastercard", 50000, 30000)
    println("Комиссия за перевод составит $result рублей.")
}

fun commissionCard(typeCard: String = "Мир", sumMonthTransfer: Int = 0, transfer: Int): Int {
   return when (typeCard) {
       "Мир" -> 0
       "Visa" -> {
           val result = (transfer * 0.0075).toInt()
           if (result < 35) 35 else result
       }
       "Mastercard" -> {
           val upLimit = sumMonthTransfer + transfer - 75000
           if (upLimit <= 0) 0 else (upLimit * 0.006 + 20).toInt()
       }
       else -> -1
    }
}
