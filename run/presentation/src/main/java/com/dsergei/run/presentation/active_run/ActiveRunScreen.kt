@file:OptIn(ExperimentalMaterial3Api::class)

package com.dsergei.run.presentation.active_run

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsergei.core.presentation.desingsystem.RunningTrackerTheme
import com.dsergei.core.presentation.desingsystem.StartIcon
import com.dsergei.core.presentation.desingsystem.StopIcon
import com.dsergei.core.presentation.desingsystem.components.RuniqueFloatingActionButton
import com.dsergei.core.presentation.desingsystem.components.RuniqueScaffold
import com.dsergei.core.presentation.desingsystem.components.RuniqueToolbar
import com.dsergei.run.presentation.R
import com.dsergei.run.presentation.active_run.components.RunDataCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActiveRunScreenRoot(
    viewModel: ActiveRunViewModel = koinViewModel(),
) {
    ActiveRunScreen(
        state = viewModel.state,
        onAction = {}
    )
}

@Composable
private fun ActiveRunScreen(
    state: ActiveRunState,
    onAction: (ActiveRunAction) -> Unit
) {
    RuniqueScaffold(
        withGradient = false,
        topAppBar = {
            RuniqueToolbar(
                showBackButton = true,
                title = stringResource(id = R.string.active_run),
                onBackClick = {
                    onAction(ActiveRunAction.OnBackClick)
                },
            )
        },
        floatingActionButton = {
            RuniqueFloatingActionButton(
                icon = if (state.shouldTrack) {
                    StopIcon
                } else {
                    StartIcon
                },
                onClick = {
                    onAction(ActiveRunAction.OnToggleRunClick)
                },
                iconSize = 20.dp,
                contentDescription = if (state.shouldTrack) {
                    stringResource(id = R.string.pause_run)
                } else {
                    stringResource(id = R.string.start_run)
                }
            )
        }
    ) { padding ->
        RunDataCard(
            elapsedTime = state.elapsedTime,
            runData = state.runData,
            modifier = Modifier
                .padding(16.dp)
                .padding(padding)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun ActiveRunScreenPreview() {
    RunningTrackerTheme {
        ActiveRunScreen(
            state = ActiveRunState(),
            onAction = {}
        )
    }
}