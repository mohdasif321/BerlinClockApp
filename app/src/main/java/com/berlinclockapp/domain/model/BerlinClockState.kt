package com.berlinclockapp.domain.model

import com.berlinclockapp.utility.LightColor

data class BerlinClockState(
    val secondLight: LightColor,
    val topHourLights: List<LightColor>,
    val bottomHourLights: List<LightColor>,
    val topMinuteLights: List<LightColor>,
    val bottomMinuteLights: List<LightColor>,
    val time: String
)
