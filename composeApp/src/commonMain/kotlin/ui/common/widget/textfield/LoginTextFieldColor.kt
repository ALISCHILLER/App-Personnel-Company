package ui.common.widget.textfield

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ui.theme.Colors


@Composable
fun LoginTextFieldColor() = TextFieldDefaults.textFieldColors(
    textColor = Colors.Dark,
    backgroundColor = Color.Transparent,
    cursorColor = Colors.Dark50,
    focusedLabelColor = Colors.Dark75,
    focusedIndicatorColor = Colors.Primary,
    unfocusedIndicatorColor = Colors.Dark50,
    unfocusedLabelColor = Colors.Dark50,
    errorIndicatorColor = Colors.Error,
    errorCursorColor = Colors.Error,
    errorLabelColor = Colors.Error,
    placeholderColor = Colors.Dark50,
    disabledPlaceholderColor = Colors.Dark25,
    disabledTextColor = Colors.Dark25,
    disabledLabelColor = Colors.Dark25,
    disabledIndicatorColor = Colors.Dark25,
)