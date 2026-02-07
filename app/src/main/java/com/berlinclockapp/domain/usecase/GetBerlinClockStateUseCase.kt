package com.berlinclockapp.domain.usecase

import com.berlinclockapp.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclockapp.constants.HOUR_LIGHT_COUNT
import com.berlinclockapp.constants.HOUR_LIGHT_VALUE
import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclockapp.constants.TOP_MINUTE_LIGHT_VALUE
import com.berlinclockapp.utility.LightColor

class GetBerlinClockStateUseCase {
    fun getSecondLight(seconds: Int): LightColor {
        return if (seconds % 2 == 0) LightColor.YELLOW else LightColor.OFF
    }

    fun getTopMinutesLight(minutes: Int): List<LightColor> {
        val topMinutesLight = MutableList(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF }
        val topMinutesOnLightCount = minutes / TOP_MINUTE_LIGHT_VALUE

        (0..<topMinutesOnLightCount).forEach { index -> topMinutesLight[index]  = if ((index + 1) % 3 == 0) LightColor.RED else LightColor.YELLOW }
        return topMinutesLight
    }

    fun getBottomMinutesLight(minutes: Int): List<LightColor> {
        val bottomMinutesLight = MutableList(BOTTOM_MINUTE_LIGHT_COUNT) { LightColor.OFF }

        val bottomMinutesOnLightCount =  minutes % TOP_MINUTE_LIGHT_VALUE
        (0..< bottomMinutesOnLightCount).forEach { index -> bottomMinutesLight[index] = LightColor.YELLOW }

        return bottomMinutesLight
    }

    fun getTopHourLight(hour: Int): List<LightColor> {
        val topHoursLight = MutableList(HOUR_LIGHT_COUNT) { LightColor.OFF }
        val topHoursOnLightCount = hour / HOUR_LIGHT_VALUE

        (0..<topHoursOnLightCount).forEach { index -> topHoursLight[index] = LightColor.RED }
        return topHoursLight
    }

    fun getBottomHourLight(hours: Int): List<LightColor> {
        val bottomHoursLight = MutableList(HOUR_LIGHT_COUNT) { LightColor.OFF }
        val bottomHoursLightCount = hours % HOUR_LIGHT_VALUE

        (0..<bottomHoursLightCount).forEach { index -> bottomHoursLight[index] = LightColor.RED }
        return bottomHoursLight
    }
}