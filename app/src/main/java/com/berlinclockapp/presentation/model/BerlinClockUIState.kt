package com.berlinclockapp.presentation.model

import com.berlinclockapp.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclockapp.constants.HOUR_LIGHT_COUNT
import com.berlinclockapp.constants.INITIAL_TIME
import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclockapp.utility.LightColor

data class BerlinClockUIState(
    val secondLight: LightColor = LightColor.OFF,
    val topHourLight: List<LightColor> = List(HOUR_LIGHT_COUNT) { LightColor.OFF },
    val bottomHourLight: List<LightColor> = List(HOUR_LIGHT_COUNT) { LightColor.OFF },
    val topMinuteLight: List<LightColor> = List(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF },
    val bottomMinuteLight: List<LightColor> = List(BOTTOM_MINUTE_LIGHT_COUNT) { LightColor.OFF },
    val time: String = INITIAL_TIME
)