package com.ejercicio.ml

import java.math.BigDecimal
import java.math.RoundingMode

class Point(val x: Double, val y: Double, private val scale: Int = 2) {
    fun distanceFrom(p: Point): Double {
        val c1 = x - p.x
        val c2 = y - p.y
        return Math.sqrt(c1 * c1 + c2 * c2)
    }

    fun rp() = Point(rounded(x), rounded(y))

    private fun rounded(d: Double) = BigDecimal(d).setScale(scale, RoundingMode.HALF_UP).toDouble()
}

class Line(private val a: Point, private val b: Point) {
    fun contains(c: Point): Boolean {
        if (a.rp().x == c.rp().x) return b.rp().x == c.rp().x //horizontal
        if (a.rp().y == c.rp().y) return b.rp().y == c.rp().y //vertical
        return a.rp().distanceFrom(c.rp()) + b.rp().distanceFrom(c.rp()) == a.rp().distanceFrom(b.rp())
    }
}

/**
 * from http://www.dma.fi.upm.es/personal/mabellanas/tfcs/kirkpatrick/Aplicacion/algoritmos.htm#puntoInterior
 */
class Triangle(private val a1: Point, private val a2: Point, private val a3: Point, private var maxPerimeter: Double = 0.0) {
    fun contains(p: Point): Boolean {
        // 2. Calcular la orientación de los triángulos que forma el punto P con los vértices del triángulo A1A2A3.
        // Se calcula la orientación de los triángulos A1A2P, A2A3P, A3A1P, con el método explicado en el punto 1.
        val a1a2p = Triangle(a1, a2, p).orientation()
        val a2a3p = Triangle(a2, a3, p).orientation()
        val a3a1p = Triangle(a3, a1, p).orientation()

        // 3. En el caso de que la orientación del triángulo A1A2A3 sea positiva.
        return if (Triangle(a1, a2, a3).orientation() == TriangleOrientation.POSITIVE) {
            // Si las orientaciones de los tres triángulos que tienen como vértice el punto P, calculadas en el punto 2, son positivas el punto está dentro del triángulo.
            // En caso contrario el punto está situado fuera del triángulo
            listOf(a1a2p, a2a3p, a3a1p).stream().allMatch({ it == TriangleOrientation.POSITIVE })
        } else {
            // 4. En el caso de que la orientación del triángulo A1A2A3 sea negativa:
            // Si las orientaciones de los tres triángulos que triángulos que tienen como vértice el punto P son negativas, el punto está dentro del triángulo
            // En caso contrario el punto está situado fuera del triángulo.
            listOf(a1a2p, a2a3p, a3a1p).stream().allMatch({ it == TriangleOrientation.NEGATIVE })
        }
    }

    // 1. Calcular la orientación del triángulo A1A2A3.
    // El cálculo de la orientación de un triángulo se puede realizar según la siguiente fórmula:
    //   (A1.x - A3.x) * (A2.y - A3.y) - (A1.y - A3.y) * (A2.x - A3.x)
    // Si el resultado es mayor o igual que 0, la orientación del triángulo será positiva. En caso contrario, la orientación del triángulo será negativa.
    private fun orientation(): TriangleOrientation {
        return if ((a1.x - a3.x) * (a2.y - a3.y) - (a1.y - a3.y) * (a2.x - a3.x) >= 0)
            TriangleOrientation.POSITIVE
        else
            TriangleOrientation.NEGATIVE
    }

    fun isMaxPerimeter(): Boolean {
        val actualPerimeter = a1.distanceFrom(a2) + a2.distanceFrom(a3)
        return if (actualPerimeter > maxPerimeter) {
            maxPerimeter = actualPerimeter
            true
        } else {
            false
        }
    }

    enum class TriangleOrientation {
        POSITIVE, NEGATIVE
    }
}