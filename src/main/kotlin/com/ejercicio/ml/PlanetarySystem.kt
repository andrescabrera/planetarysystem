package com.ejercicio.ml

import java.lang.Math.cos
import java.lang.Math.sin
import java.lang.Math.toRadians


enum class Orientation {
    CLOCKWISE, COUNTERCLOCKWISE
}

data class Planet(private val angularSpeedAtDay: Int, private val orientation: Orientation, private val distanceToSun: Double) {

    private var orbitLocation: Double = 0.0;
    private var position: Point = Point(0.0, distanceToSun)

    fun position(sunPosition: Point): Point {
        return Point(position.x, sunPosition.y + distanceToSun)
    }

    fun moveDayForward() {

        orbitLocation = if (orientation == Orientation.CLOCKWISE) orbitLocation - angularSpeedAtDay else orbitLocation + angularSpeedAtDay

        if (orbitLocation > 360) orbitLocation -= 360
        if (orbitLocation < 0) orbitLocation += 360

        val x = cos(toRadians(orbitLocation))
        val y = sin(toRadians(orbitLocation))

        position = Point(x * distanceToSun, y * distanceToSun)
    }
}

class PlanetarySystem(private val sun: Point = Point(0.0, 0.0),
                      private val ferengi: Planet = Planet(1, Orientation.CLOCKWISE, 500.0),
                      private val betasoide: Planet = Planet(3, Orientation.CLOCKWISE, 2000.0),
                      private val vulcano: Planet = Planet(5, Orientation.COUNTERCLOCKWISE, 1000.0)) {

    fun isDrought(): Boolean {
        val line = Line(ferengi.position(sun), sun)
        return line.contains(betasoide.position(sun)) && line.contains(vulcano.position(sun))
    }

    fun moveDayForward() {
        ferengi.moveDayForward()
        betasoide.moveDayForward()
        vulcano.moveDayForward()
    }

}