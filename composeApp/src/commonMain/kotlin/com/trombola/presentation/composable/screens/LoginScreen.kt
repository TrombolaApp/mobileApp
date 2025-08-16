package com.trombola.presentation.composable.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.trombola.presentation.composable.elements.buttons.LoginButton
import com.trombola.presentation.composable.elements.textFields.PasswordTextField
import com.trombola.presentation.composable.elements.textFields.UsernameTextField
import org.jetbrains.compose.resources.painterResource
import trombola.composeapp.generated.resources.Res
import trombola.composeapp.generated.resources.trombola_logo_text

@Composable
fun LoginScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Image(
            painterResource(Res.drawable.trombola_logo_text),
            contentDescription = "trombola_logo"
        )
        Spacer(modifier = Modifier.size(30.dp))
        UsernameTextField()
        PasswordTextField()
        Spacer(modifier = Modifier.size(30.dp))
        LoginButton()
    }
}