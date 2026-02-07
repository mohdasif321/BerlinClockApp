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
    fun `test all top minutes lights are On when minute is greater than 54 and less than 60 mins`() {
        val minutes = 55

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        minutesLightStates.forEach {
            Assert.assertEquals(true, (LightColor.YELLOW == it) || (LightColor.RED == it))
        }
    }

    @Test
    fun `test all top minutes lights are not On when minute is not greater than 54`() {
        val minutes = 54

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        Assert.assertEquals(true, minutesLightStates.any { it == LightColor.OFF })
    }

    @Test
    fun `test top minutes light row is not having red light On when minutes are less than 15 mins`() {
        val minutes = 14

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        Assert.assertEquals(false, minutesLightStates.any { it == LightColor.RED })
    }

    @Test
    fun `test top minutes light row is having at least one red light On when minutes are greater than 15 mins`() {
        val minutes = 15

        val minutesLightStates = getBerlinClockStateUseCase.getTopMinutesLight(minutes)

        Assert.assertEquals(true, minutesLightStates.any { it == LightColor.RED })
    }

    @Test
    fun `test all Bottom minutes lights are Off when minute is divisible by 5`() {
        val minutes = 15

        val minutesLightStates = getBerlinClockStateUseCase.getBottomMinutesLight(minutes)

        minutesLightStates.forEach {
            Assert.assertEquals(LightColor.OFF, it)
        }
    }

    @Test
    fun `test at least one Bottom minutes light is On when minutes is not divisible by 5`() {
        val minutes = 16

        val minutesLightStates = getBerlinClockStateUseCase.getBottomMinutesLight(minutes)

        Assert.assertEquals( true,  minutesLightStates.any { it == LightColor.YELLOW })
    }

    @Test
    fun `test all bottom minutes lights are On`() {
        val minutes = 19

        val minutesLightStates = getBerlinClockStateUseCase.getBottomMinutesLight(minutes)

        Assert.assertEquals( true,  minutesLightStates.all { it == LightColor.YELLOW })
    }

    @Test
    fun `test when all top hour lights are Off`() {
        val hours = 0

        val hourLightStates = getBerlinClockStateUseCase.getTopHourLight(hours)

        hourLightStates.forEach {
            Assert.assertEquals(LightColor.OFF, it)
        }
    }

    @Test
    fun `test when all top hour lights are On`() {
        val hours = 21
        val hourLightStates = getBerlinClockStateUseCase.getTopHourLight(hours)

        Assert.assertEquals( true,  hourLightStates.all { it == LightColor.RED })
    }

    @Test
    fun `test when at least on top hour lights is On`() {
        val hours = 6
        val hourLightStates = getBerlinClockStateUseCase.getTopHourLight(hours)

        Assert.assertEquals( true,  hourLightStates.any { it == LightColor.RED })
    }

    @Test
    fun `test when all bottom hour lights are Off`() {
        val hours = 0

        val hourLightStates = getBerlinClockStateUseCase.getBottomHourLight(hours)

        hourLightStates.forEach {
            Assert.assertEquals(LightColor.OFF, it)
        }
    }

    @Test
    fun `test when all bottom hour lights are On`() {
        val hours = 14
        val hourLightStates = getBerlinClockStateUseCase.getBottomHourLight(hours)

        Assert.assertEquals( true,  hourLightStates.all { it == LightColor.RED })
    }

    @Test
    fun `test when at least on bottom hour light is On`() {
        val hours = 12
        val hourLightStates = getBerlinClockStateUseCase.getBottomHourLight(hours)

        Assert.assertEquals( true,  hourLightStates.any { it == LightColor.RED })
    }

    @Test
    fun `test GetBerlinClockStateUseCase() for a given formatted time and return BerlinClockState with second light off`() {
        val stringTime = "14:36:07"

        val berlinClockState = getBerlinClockStateUseCase(stringTime)

        Assert.assertEquals(LightColor.OFF,  berlinClockState.secondLight)
    }
}
