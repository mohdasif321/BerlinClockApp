package com.berlinclockapp.domain.usecase

import com.berlinclockapp.utility.LightColor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetBerlinClockStateUseCaseTest {
    private lateinit var getBerlinClockStateUseCase: GetBerlinClockStateUseCase

    @Before
    fun setup() {
        getBerlinClockStateUseCase = GetBerlinClockStateUseCase()
    }

    @Test
    fun `test when secondLight is Off for Odd Second`() {
        val second = 1

        val secondLightIsOff = getBerlinClockStateUseCase.getSecondLight(second)

        Assert.assertEquals( LightColor.OFF, secondLightIsOff)
    }

    @Test
    fun `test when secondLight is On for Even Second`() {
        val second = 12

        val secondLightState = getBerlinClockStateUseCase.getSecondLight(second)

        Assert.assertEquals(LightColor.YELLOW, secondLightState)
    }

    @Test
    fun `test when all top minutes lights are Off at complete hour`() {
        val minutes = 0

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        minutesLightStates.forEach {
            Assert.assertEquals(LightColor.OFF, it)
        }
    }

    @Test
    fun `test all top minutes lights are Off when minute is under 5 mins`() {
        val minutes = 4

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        minutesLightStates.forEach {
            Assert.assertEquals(LightColor.OFF, it)
        }
    }

    @Test
    fun `test all top minutes light is On when minutes is greater than 54 and less than 60 mins`() {
        val minutes = 55

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        minutesLightStates.forEach {
            Assert.assertTrue( it == LightColor.YELLOW)
        }
    }
}
