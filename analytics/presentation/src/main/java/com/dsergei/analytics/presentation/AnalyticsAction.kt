package com.dsergei.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}