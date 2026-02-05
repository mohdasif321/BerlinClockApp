package com.berlinclockapp.presentation.model

import utility.LightColor

data class BerlinClockUIState(
    val secondLight: LightColor = LightColor.OFF,
    val topHourLight: List<LightColor> = List(4) { LightColor.OFF },
    val bottomHourLight: List<LightColor> = List(4) { LightColor.OFF },
    val topMinuteLight: List<LightColor> = List(11) { LightColor.OFF },
    val bottomMinuteLight: List<LightColor> = List(4) { LightColor.OFF },
)