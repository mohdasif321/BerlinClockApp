package com.berlinclockapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.berlinclockapp.presentation.model.BerlinClockUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BerlinClockViewModel: ViewModel() {
    private var _berlinClockState = MutableStateFlow<BerlinClockUIState>(BerlinClockUIState())
    val berlinClockState: StateFlow<BerlinClockUIState>
        get() = _berlinClockState
}