package com.berlinclockapp.presentation.viewmodel

import com.berlinclockapp.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclockapp.constants.HOUR_LIGHT_COUNT
import com.berlinclockapp.constants.INITIAL_TIME
import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_COUNT
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import com.berlinclockapp.utility.LightColor

class BerlinClockViewModelTest {

    private lateinit var berlinClockViewModel: BerlinClockViewModel

    @Before
    fun setup() {
        berlinClockViewModel = BerlinClockViewModel()
    }

    @Test
    fun `check secondLight is initially Off`() {
        Assert.assertTrue(berlinClockViewModel.berlinClockState.value.secondLight == LightColor.OFF)
    }

    @Test
    fun `check topHourLight are initially OFF`() {
        Assert.assertTrue(berlinClockViewModel.berlinClockState.value.topHourLight == List(HOUR_LIGHT_COUNT) { LightColor.OFF })
    }

    @Test
    fun `check bottomHourLight are initially OFF`() {
        Assert.assertTrue(berlinClockViewModel.berlinClockState.value.bottomHourLight == List(HOUR_LIGHT_COUNT) { LightColor.OFF })
    }

    @Test
    fun `check topMinuteLight are initially OFF`() {
        Assert.assertTrue(berlinClockViewModel.berlinClockState.value.topMinuteLight == List(
            TOP_MINUTE_LIGHT_COUNT
        ) { LightColor.OFF })
    }

    @Test
    fun `check bottomMinuteLight are initially OFF`() {
        Assert.assertTrue(berlinClockViewModel.berlinClockState.value.bottomMinuteLight == List(
            BOTTOM_MINUTE_LIGHT_COUNT
        ) { LightColor.OFF })
    }

    @Test
    fun `check initial time value`() {
        Assert.assertTrue(berlinClockViewModel.berlinClockState.value.time == INITIAL_TIME)
    }
}