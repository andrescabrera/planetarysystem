package com.ejercicio.ml

import kotlin.test.assertEquals
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

    @test
    fun `test PlanetarySystem IsRaining must be raining on starting position`() {

        val ps = PlanetarySystem()

        assertTrue(ps.isRaining())
    }

    @test
    fun `test PlanetarySystem IsRaining must not be raining on next day`() {

        val ps = PlanetarySystem()

        ps.moveDayForward()

        assertFalse(ps.isRaining())
    }

    @test
    fun `test PlanetarySystem is Max RainFlow`() {

        val ps = PlanetarySystem()

        assertTrue(ps.isMaxRainFlow())
    }

    @test
    fun `test PlanetarySystem check if its in optimal weather conditions`() {

        val ps = PlanetarySystem()

        assertFalse(ps.isInOptimalConditions())
    }

    @test
    fun `test PlanetarySystem get actual day forecast must return drought`() {

        val ps = PlanetarySystem()

        assertEquals(Weather.DROUGHT, ps.forecast())
    }
}

