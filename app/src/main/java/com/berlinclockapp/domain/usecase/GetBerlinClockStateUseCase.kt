package com.berlinclockapp.domain.usecase

import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclockapp.utility.LightColor

class GetBerlinClockStateUseCase {
    fun getSecondLight(seconds: Int): LightColor {
        return if (seconds % 2 == 0) LightColor.YELLOW else LightColor.OFF
    }

    fun getTopMinutesLight(minutes: Int): List<LightColor> {
        return List(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF }
    }
}