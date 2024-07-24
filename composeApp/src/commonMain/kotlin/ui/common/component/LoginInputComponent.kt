package ui.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import ui.common.widget.button.MyZarButton
import ui.common.widget.textfield.PasswordTextField
import ui.common.widget.textfield.UserNameTextField
import ui.theme.FontSizeLarge
import ui.theme.Peyda
import util.MyZarText
import ui.theme.PaddingExtraLarge

//-------------------------------------------------------------------------------------------------- LoginInputComponent
@Composable
fun LoginInputComponent(
    modifier: Modifier,
    userNameValue: String,
    userNameIsError: Boolean,
    passwordValue: String,
    passwordIsError: Boolean,
    loading: Boolean,
    verticalArrangement: Arrangement.Vertical,
    horizontalAlignment: Alignment.Horizontal,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = verticalArrangement,
        horizontalAlignment = horizontalAlignment
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = MyZarText.PleaseEnterUserNamePassword,
            fontFamily = Peyda(),
            fontSize = FontSizeLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
        UserNameTextField(
            modifier = Modifier
                .padding(top = PaddingExtraLarge)
                .fillMaxWidth(),
            value = userNameValue,
            isError = userNameIsError,
            onValueChange = onUserNameChange
        )
        PasswordTextField(
            modifier = Modifier
                .padding(top = PaddingExtraLarge)
                .fillMaxWidth(),
            value = passwordValue,
            isError = passwordIsError,
            onValueChange = onPasswordChange
        )

        MyZarButton(
            modifier = Modifier.padding(top = PaddingExtraLarge).fillMaxWidth(),
            text = MyZarText.Login,
            enabled = true,
            loading = loading,
            onClick = {
                onLoginClick.invoke()
            }
        )
    }
}
//-------------------------------------------------------------------------------------------------- LoginInputComponent