package com.ejercicio.ml

enum class Orientation {
    CLOCKWISE, COUNTERCLOCKWISE
}

class PlanetarySystem(private val sun: Point = Point(0.0, 0.0),
                      private val ferengi: Planet = Planet(1, Orientation.CLOCKWISE, 500.0),
                      private val betasoide: Planet = Planet(3, Orientation.CLOCKWISE, 2000.0),
                      private val vulcano: Planet = Planet(5, Orientation.COUNTERCLOCKWISE, 1000.0)) {

    fun moveDayForward() {
        ferengi.moveDayForward()
        betasoide.moveDayForward()
        vulcano.moveDayForward()
    }

    fun isDrought(): Boolean {
        val line = Line(ferengi.position(), sun)
        return line.contains(betasoide.position()) && line.contains(vulcano.position())
    }

    fun isRaining() = Triangle(ferengi.position(), betasoide.position(), vulcano.position()).contains(sun)

    fun isMaxRainFlow() = Triangle(ferengi.position(), betasoide.position(), vulcano.position()).isMaxPerimeter()

    fun isInOptimalConditions(): Boolean {
        val line = Line(ferengi.position(), betasoide.position())
        return line.contains(vulcano.position()) && !line.contains(sun)
    }

    fun forecast(): Weather {
        return when {
            isDrought() -> return Weather.DROUGHT
            isRaining() -> return Weather.RAINING
            isInOptimalConditions() -> Weather.OPTIMAL_CONDITIONS
            else -> return Weather.NORMAL
        }
    }
}