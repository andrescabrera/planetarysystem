package com.ejercicio.ml

import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.Test as test

class PointTest {

    @test
    fun `test Point to Line distance`() {

        val p1 = Point(1.5, 2.5)
        val p2 = Point(3.5, 5.0)

        assertEquals(3.2015621187164243, p1.distanceFrom(p2))
    }

    @test
    fun `test if Line contains Point`() {
        val a = Point(2.0, 3.0)
        val b = Point(6.0, 5.0)
        assertTrue(Line(a, b).contains(Point(4.0, 4.0)))
    }
}

