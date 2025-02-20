package com.dsergei.runningtracker

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.dsergei.auth.presentation.intro.IntroScreenRoot
import com.dsergei.auth.presentation.login.LoginScreenRoot
import com.dsergei.auth.presentation.register.RegisterScreenRoot
import com.dsergei.run.presentation.active_run.ActiveRunScreenRoot
import com.dsergei.run.presentation.run_overview.RunOverviewScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Routes.Run else Routes.Auth
    ) {
        authGraph(navController)
        runGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<Routes.Auth>(
        startDestination = Routes.Intro,
    ) {
        composable<Routes.Intro> {
            IntroScreenRoot(
                onSignUpClick = {
                    navController.navigate(Routes.Register)
                },
                onSignInClick = {
                    navController.navigate(Routes.Login)
                }
            )
        }
        composable<Routes.Register> {
            RegisterScreenRoot(
                onSignInClick = {
                    navController.navigate(Routes.Login) {
                        popUpTo(Routes.Register) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(Routes.Login)
                }
            )
        }
        composable<Routes.Login> {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate(Routes.Run) {
                        popUpTo(Routes.Auth) {
                            inclusive = true
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(Routes.Register) {
                        popUpTo(Routes.Login) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.runGraph(
    navController: NavHostController,
) {
    navigation<Routes.Run>(
        startDestination = Routes.RunOverview,
    ) {
        composable<Routes.RunOverview> {
            RunOverviewScreenRoot(
                onStartRunClick = { navController.navigate(Routes.ActiveRun) },
                onLogoutClick = {},
                onAnalyticsClick = {},
            )
        }
        composable<Routes.ActiveRun> {
            ActiveRunScreenRoot()
        }
    }
}