package com.dsergei.run.presentation.active_run

import com.dsergei.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val error: UiText) : ActiveRunEvent
}