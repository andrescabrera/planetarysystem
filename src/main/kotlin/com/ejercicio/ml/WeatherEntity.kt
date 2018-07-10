package com.ejercicio.ml

data class WeatherEntity(val day: Int, val weather: Weather)

enum class Weather {
    DROUGHT, RAINING, OPTIMAL_CONDITIONS, NORMAL
}