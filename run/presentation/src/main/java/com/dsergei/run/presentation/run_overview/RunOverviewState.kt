package com.dsergei.run.presentation.run_overview

import com.dsergei.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
