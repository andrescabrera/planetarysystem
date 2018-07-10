package com.ejercicio.ml

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ForecastServiceTest {

    @Test
    fun `test ForecastService to check if it is able to generate 10 years forecast`() {
        val planetarySystem = PlanetarySystem()
        val service = ForecastService(planetarySystem)

        assertNotNull(service.forecasts)

        service.forecasts.groupBy { it.weather }.forEach({ t, u ->
            println("name: ${t.name}, size: ${u.size}")
        })

        assertEquals(WeatherEntity(1, Weather.DROUGHT), service.forecasts.elementAt(0))
        assertEquals(WeatherEntity(3650, Weather.NORMAL), service.forecasts.elementAt(3649))
    }
}
