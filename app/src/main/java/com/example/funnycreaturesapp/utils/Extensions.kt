package com.example.funnycreaturesapp.utils

import java.math.RoundingMode

fun Double.roundDouble(): Double {
    return this.toBigDecimal()
        .setScale(2, RoundingMode.UP)
        .toDouble()
}

fun String.capitaliseFirstChar(): String =
    this.lowercase().replaceFirstChar { it.uppercaseChar() }

fun Int.decreaseIntegerSafely(): Int {
    return if (this > 1) this - 1 else this
}