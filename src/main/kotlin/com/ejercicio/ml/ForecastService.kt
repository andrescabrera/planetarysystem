package com.ejercicio.ml

class ForecastService(planetarySystem: PlanetarySystem = PlanetarySystem(), years: Int = 10, val forecasts: LinkedHashSet<WeatherEntity> = linkedSetOf()) {

    init {
        val totalDays = years * 365

        for (day in 1..totalDays) {
            forecasts += WeatherEntity(day, planetarySystem.forecast())
            planetarySystem.moveDayForward()
        }

        persist(forecasts.toList())
    }

    private fun persist(forecasts: List<WeatherEntity>) {
        println("Saved ${forecasts.size} forecasts") // TODO database persistance
    }
}