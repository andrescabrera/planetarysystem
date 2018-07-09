package com.ejercicio.ml

class Point(val x: Double, val y: Double) {
    fun distanceFrom(p: Point): Double {
        val c1 = x - p.x
        val c2 = y - p.y
        return Math.sqrt(c1 * c1 + c2 * c2)
    }
}

class Line(val a: Point, val b: Point) {
    fun contains(c: Point): Boolean {
        if (a.x == c.x) return b.x == c.x //horizontal
        if (a.y == c.y) return b.y == c.y //vertical
        return a.distanceFrom(c) + b.distanceFrom(c) == a.distanceFrom(b)
    }
}

class Triangle() {}