package ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.common.component.LoginInputComponent
import ui.common.component.MyZarLogo
import ui.theme.Background
import ui.theme.Colors
import ui.theme.Peyda
import ui.theme.CornerSizeExtraLarge
import ui.theme.FontSizeLarge
import util.MyZarText
import ui.theme.PaddingExtraLarge


@Composable
internal fun LoginExpandedScreen(
    userNameValue: String,
    userNameIsError: Boolean,
    passwordValue: String,
    passwordIsError: Boolean,
    loading: Boolean,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.3f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MyZarLogo(modifier = Modifier
                .fillMaxWidth(0.4f)
                .padding(top = 30.dp))

            Text(
                modifier = Modifier
                    .padding(
                        top = 30.dp,
                        start = PaddingExtraLarge,
                        end = PaddingExtraLarge
                    ),
                text = MyZarText.Welcome,
                fontFamily = Peyda(),
                fontSize = FontSizeLarge,
                color = Colors.White
            )
        }

        LoginInputComponent(
            modifier = Modifier
                .padding(start = PaddingExtraLarge)
                .fillMaxHeight()
                .weight(0.6f)
                .background(
                    color = Colors.White,
                    shape = RoundedCornerShape(
                        topStart = CornerSizeExtraLarge,
                        bottomStart = CornerSizeExtraLarge
                    )
                )
                .padding(30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            userNameValue = userNameValue,
            userNameIsError = userNameIsError,
            passwordValue = passwordValue,
            loading = loading,
            passwordIsError = passwordIsError,
            onUserNameChange = onUserNameChange,
            onPasswordChange = onPasswordChange,
            onLoginClick = onLoginClick
        )
    }
}