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
}
