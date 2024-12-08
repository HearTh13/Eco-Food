package com.prod.ecofood.utilities

import java.text.NumberFormat
import java.util.Locale

class NumberFormatter {
    fun formatToId(price: Int): String{
        val locale = Locale("id", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(locale)
        return numberFormat.format(price)
    }
}