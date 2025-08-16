package com.trombola.presentation.composable.elements.textFields

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import trombola.composeapp.generated.resources.Res
import trombola.composeapp.generated.resources.user
import trombola.composeapp.generated.resources.username_text_field

@Composable
fun UsernameTextField() {
    BaseTextField(
        labelText = stringResource(Res.string.username_text_field),
        initialHideText = false,
        leadingIconSrc = Res.drawable.user
    )
}