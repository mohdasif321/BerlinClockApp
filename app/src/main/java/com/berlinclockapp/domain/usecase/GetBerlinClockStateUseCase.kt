package com.berlinclockapp.domain.usecase

import com.berlinclockapp.utility.LightColor

class GetBerlinClockStateUseCase {
    fun getSecondLight(seconds: Int): LightColor {
        return LightColor.OFF
    }
}