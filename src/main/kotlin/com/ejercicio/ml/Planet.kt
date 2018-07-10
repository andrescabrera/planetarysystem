package com.ejercicio.ml

class Planet(private val angularSpeedAtDay: Int, private val orientation: Orientation, private val distanceToSun: Double, private var position: Point = Point(0.0, distanceToSun), private var orbitLocation: Double = 0.0) {

    fun position() = Point(position.x, position.y)

    fun moveDayForward() {
        orbitLocation = if (orientation == Orientation.CLOCKWISE) orbitLocation - angularSpeedAtDay else orbitLocation + angularSpeedAtDay

        if (orbitLocation > 360) orbitLocation -= 360
        if (orbitLocation < 0) orbitLocation += 360

        val x = Math.cos(Math.toRadians(orbitLocation))
        val y = Math.sin(Math.toRadians(orbitLocation))

        position = Point(x * distanceToSun, y * distanceToSun)
    }
}