package com.trombola.presentation.composable.elements.buttons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import trombola.composeapp.generated.resources.Res
import trombola.composeapp.generated.resources.login_button_text

@Composable
fun LoginButton() {
    BaseButton(
        text = stringResource(Res.string.login_button_text)
    ) {
        /* TODO: add a class in application layer that handles the
        *   request to authenticate the user. */
    }
}