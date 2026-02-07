package com.berlinclockapp.domain.usecase

import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_VALUE
import com.berlinclockapp.utility.LightColor

class GetBerlinClockStateUseCase {
    fun getSecondLight(seconds: Int): LightColor {
        return if (seconds % 2 == 0) LightColor.YELLOW else LightColor.OFF
    }

    fun getTopMinutesLight(minutes: Int): List<LightColor> {
        val topMinutesLight = MutableList(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF }

        (0..< (minutes / TOP_MINUTE_LIGHT_VALUE)).forEach { index -> topMinutesLight[index]  = LightColor.YELLOW }
        return topMinutesLight
    }
}