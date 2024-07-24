package ui.common.widget.textfield

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import ui.theme.Colors
import util.MyZarText

//-------------------------------------------------------------------------------------------------- UserNameTextField
@Composable
fun UserNameTextField(
    modifier: Modifier,
    value: String,
    isError: Boolean,
    onValueChange: (String) -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    MyZarTextField(
        modifier = modifier,
        value = value,
        label = MyZarText.UserName,
        isError = isError,
        maxLines = 1,
        colors = LoginTextFieldColor(),
        maxLength = 50,
        imeAction = ImeAction.Done,
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
    ) {text ->
        onValueChange.invoke(text)
    }
}
//-------------------------------------------------------------------------------------------------- UserNameTextField