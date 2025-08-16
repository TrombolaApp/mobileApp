package com.trombola

import androidx.compose.ui.window.ComposeUIViewController
import com.trombola.presentation.composable.screens.LoginScreen

fun MainViewController() = ComposeUIViewController { LoginScreen() }