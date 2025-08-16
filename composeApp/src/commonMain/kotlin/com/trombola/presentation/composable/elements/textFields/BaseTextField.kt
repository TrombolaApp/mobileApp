package com.trombola.presentation.composable.elements.textFields

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun BaseTextField(
    labelText: String,
    initialHideText: Boolean,
    leadingIconSrc: DrawableResource,
    leadingDescription: String = "",
    trailingIconSrc: DrawableResource? = null,
    trailingIconHiddenSrc: DrawableResource? = null,
    trailingDescription: String = ""
) {

    val text = rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue("")) }
    val hideText = rememberSaveable { mutableStateOf(initialHideText) }

    Row(
        modifier = Modifier
            .drawBehind {
                val strokeWidth = 5f
                val y = size.height - strokeWidth / 2

                drawLine(
                    Color.White,
                    Offset(30f, y - 20),
                    Offset(size.width - 30, y - 20),
                    strokeWidth
                )
            }
    ) {
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            label = { Text(labelText, color = Color.White) },
            visualTransformation =
                if (hideText.value)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None,
            singleLine = true,
            leadingIcon = {
                Icon(
                    painterResource(leadingIconSrc),
                    contentDescription = leadingDescription,
                    tint = Color.Unspecified
                )
            },
            trailingIcon = {
                if (trailingIconSrc != null) {
                    IconButton(
                        onClick = {
                            hideText.value = !hideText.value
                        }
                    ) {
                        val currentIcon =
                            if (hideText.value && trailingIconHiddenSrc != null)
                                trailingIconHiddenSrc
                            else
                                trailingIconSrc

                        Icon(
                            painterResource(currentIcon),
                            contentDescription = trailingDescription,
                            tint = Color.Unspecified
                        )
                    }
                }
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Red,
                focusedContainerColor = Color.Red,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),

            modifier = Modifier
                .padding(8.dp)
        )
    }
}