package com.ejercicio.ml

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.Test as test

class PlanetarySystemTest {

    @test
    fun `test PlanetarySystem IsDrought on Starting Position must be drought`() {

        val ps = PlanetarySystem()

        assertTrue(ps.isDrought())
    }

    @test
    fun `test PlanetarySystem IsDrought on day forward must not be drought`() {

        val ps = PlanetarySystem()

        ps.moveDayForward()

        assertFalse(ps.isDrought())
    }
}

