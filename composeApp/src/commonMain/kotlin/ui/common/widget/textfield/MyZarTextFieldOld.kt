package ui.common.widget.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.LayoutDirection
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_password_hide
import myzar.composeapp.generated.resources.ic_password_show
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ui.theme.Colors
import ui.theme.Peyda
import util.DecimalFormatter
import util.DecimalInputVisualTransformation
import ui.theme.FontSizeNormal
import ui.theme.PaddingNormal


//-------------------------------------------------------------------------------------------------- MyZarTextField
@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun MyZarTextFieldOld(
    modifier: Modifier,
    focusRequester: FocusRequester = FocusRequester(),
    value: MutableState<String>,
    isError: MutableState<Boolean> = mutableStateOf(false),
    maxLength: Int? = null,
    maxLines: Int = Int.MAX_VALUE,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardActions: KeyboardActions = KeyboardActions { },
    readOnly: Boolean = false,
    isSplit: Boolean = false,
    enabled: Boolean = true,
    isRtl: Boolean = true,
    isPassword: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null
) {

    val decimalFormatter = DecimalFormatter()
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    val actualVisualTransformation =
        if (passwordVisible.value)
            if (isSplit)
                DecimalInputVisualTransformation(decimalFormatter)
            else
                visualTransformation
        else
            PasswordVisualTransformation('*')


    val direction = if (isRtl)
        LocalLayoutDirection provides LayoutDirection.Rtl
    else
        LocalLayoutDirection provides LayoutDirection.Ltr
    CompositionLocalProvider(direction) {
        OutlinedTextField(
            modifier = modifier.focusRequester(focusRequester = focusRequester),
            value = value.value,
            shape = RoundedCornerShape(size = PaddingNormal),
            maxLines = maxLines,
            isError = isError.value,
            readOnly = readOnly,
            enabled = enabled,
            textStyle = TextStyle(
                fontSize = FontSizeNormal,
                fontFamily = Peyda(),
                fontWeight = if (readOnly) FontWeight.SemiBold else FontWeight.Normal
            ),
            onValueChange = { text ->
                isError.value = false
                maxLength?.let { max ->
                    if (text.length > max)
                        return@OutlinedTextField
                }
                value.value =
                    if (isSplit)
                        decimalFormatter.cleanup(text)
                    else
                        text
            },
            visualTransformation = actualVisualTransformation,
            label = {
                Text(
                    text = label,
                    fontFamily = Peyda(),
                    fontSize = FontSizeNormal
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Colors.Dark,
                backgroundColor = Colors.White,
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
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
            keyboardActions = keyboardActions,
            leadingIcon = leadingIcon,
            trailingIcon = {
                if (!isPassword)
                    trailingIcon?.invoke()
                else
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
        )
    }
}
//-------------------------------------------------------------------------------------------------- MyZarTextField