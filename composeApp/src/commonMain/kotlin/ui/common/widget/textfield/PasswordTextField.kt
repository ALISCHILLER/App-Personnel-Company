package ui.common.widget.textfield

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_password_hide
import myzar.composeapp.generated.resources.ic_password_show
import org.jetbrains.compose.resources.painterResource
import util.MyZarText

@Composable
fun PasswordTextField(
    modifier: Modifier,
    value: String,
    isError: Boolean,
    onValueChange: (String) -> Unit = {}
) {
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    val visualTransformation =
        if (passwordVisible.value)
            VisualTransformation.None
        else
            PasswordVisualTransformation('*')
    val keyboardController = LocalSoftwareKeyboardController.current

    MyZarTextField(
        modifier = modifier,
        value = value,
        label = MyZarText.Password,
        isError = isError,
        maxLines = 1,
        maxLength = 50,
        imeAction = ImeAction.Done,
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        colors = LoginTextFieldColor(),
        visualTransformation = visualTransformation,
        trailingIcon = {
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                if (passwordVisible.value)
                    Icon(
                        painter = painterResource(Res.drawable.ic_password_hide),
                        contentDescription = "password hide"
                    )
                else
                    Icon(
                        painter = painterResource(Res.drawable.ic_password_show),
                        contentDescription = "password show"
                    )
            }
        }
    ) {text ->
        onValueChange.invoke(text)
    }

}