package com.app.i_commerce.helper

import java.text.NumberFormat
import java.util.*

/**
 * Created by Leon Truzqy Zainun on 31,December,2020
 */
class Helper {
    fun gantiRupiah(string: String): String {
        return NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(Integer.valueOf(string))
    }
}