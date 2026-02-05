package com.berlinclockapp.presentation.viewmodel

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import utility.LightColor

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
}