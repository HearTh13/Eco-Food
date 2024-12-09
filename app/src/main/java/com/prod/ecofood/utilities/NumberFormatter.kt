package com.prod.ecofood.utilities

import java.text.NumberFormat
import java.util.Locale

class NumberFormatter {
    fun formatToId(price: Int): String {
        val locale = Locale("id", "ID")
        val numberFormat = NumberFormat.getNumberInstance(locale)
        val formattedNumber = numberFormat.format(price)
        return "Rp. $formattedNumber"
    }
}