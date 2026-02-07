package com.berlinclockapp.domain.usecase

import com.berlinclockapp.utility.LightColor

class GetBerlinClockStateUseCase {
    fun getSecondLight(seconds: Int): LightColor {
        return if (seconds % 2 == 0) LightColor.YELLOW else LightColor.OFF
    }
}