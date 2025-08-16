package com.trombola.presentation.composable.elements.textFields

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.stringResource
import trombola.composeapp.generated.resources.Res
import trombola.composeapp.generated.resources.hidden
import trombola.composeapp.generated.resources.padlock
import trombola.composeapp.generated.resources.password_text_field
import trombola.composeapp.generated.resources.view

@Composable
fun PasswordTextField() {
    BaseTextField(
        labelText = stringResource(Res.string.password_text_field),
        initialHideText = true,
        leadingIconSrc = Res.drawable.padlock,
        trailingIconSrc = Res.drawable.hidden,
        trailingIconHiddenSrc = Res.drawable.view
    )
}