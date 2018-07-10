package com.ejercicio.ml

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test as test

class TriangleTest {

    @test
    fun `test Triangle must contain specific Point`() {

        val a = Point(1.0, 1.1)
        val b = Point(4.0, 2.0)
        val c = Point(1.0, 4.0)
        val triangle = Triangle(a, b, c)

        val d = Point(2.0, 2.0)

        assertTrue(triangle.contains(d))
    }

    @test
    fun `test Triangle must not contain specific Point`() {

        val a = Point(1.0, 1.1)
        val b = Point(4.0, 2.0)
        val c = Point(1.0, 4.0)
        val triangle = Triangle(a, b, c)

        val d = Point(-2.0, -2.0)

        assertFalse(triangle.contains(d))
    }
}

