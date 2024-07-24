package ui.common.widget.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.LayoutDirection
import ui.theme.CornerSizeOverExtraLarge
import ui.theme.Peyda
import ui.theme.FontSizeNormal

//-------------------------------------------------------------------------------------------------- MyZarTextField
@Composable
internal fun MyZarTextField(
    modifier: Modifier,
    focusRequester: FocusRequester = FocusRequester(),
    value: String,
    isError: Boolean = false,
    maxLength: Int? = null,
    maxLines: Int = Int.MAX_VALUE,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    isRtl: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors,
    onValueChange: (String) -> Unit = {}
) {

    val direction = if (isRtl)
        LocalLayoutDirection provides LayoutDirection.Rtl
    else
        LocalLayoutDirection provides LayoutDirection.Ltr
    CompositionLocalProvider(direction) {
        OutlinedTextField(
            modifier = modifier.focusRequester(focusRequester = focusRequester),
            value = value,
            shape = RoundedCornerShape(size = CornerSizeOverExtraLarge),
            maxLines = maxLines,
            isError = isError,
            readOnly = readOnly,
            enabled = enabled,
            textStyle = TextStyle(
                fontSize = FontSizeNormal,
                fontFamily = Peyda(),
                fontWeight = if (readOnly) FontWeight.SemiBold else FontWeight.Normal
            ),
            onValueChange = { text ->
                maxLength?.let { max ->
                    if (text.length > max)
                        return@OutlinedTextField
                }
                onValueChange.invoke(text)
            },
            visualTransformation = visualTransformation,
            label = {
                Text(
                    text = label,
                    fontFamily = Peyda(),
                    fontSize = FontSizeNormal
                )
            },
            colors = colors,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}
//-------------------------------------------------------------------------------------------------- MyZarTextField