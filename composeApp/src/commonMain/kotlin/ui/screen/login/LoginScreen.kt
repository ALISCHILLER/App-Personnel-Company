package ui.screen.login

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator
import ui.screen.zar.ZarScreen
import util.windows_size.WindowSize

//-------------------------------------------------------------------------------------------------- LoginScreen
@Composable
fun LoginScreen(
    navigator: Navigator,
    viewModel: LoginViewModel,
    windowSize: WindowSize,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()
    val login = viewModel.login
    scope.launch {
        delay(1500)
        if (login.data == true)
            navigator.goBack()
    }

    ZarScreen(
        navigator = navigator,
        message = login.message,
        mySnackBarHostState = mySnackBarHostState,
        snackBarContainerColor = snackBarContainerColor
    ) {
        when (windowSize) {
            WindowSize.COMPACT -> {
                LoginCompactScreen(
                    userNameValue = viewModel.userName.value,
                    userNameIsError = viewModel.userNameError.value,
                    passwordValue = viewModel.password.value,
                    passwordIsError = viewModel.passwordError.value,
                    loading = login.isLoading,
                    onUserNameChange = { viewModel.userName.value = it },
                    onPasswordChange = { viewModel.password.value = it },
                    onLoginClick = {
                        keyboardController?.hide()
                        viewModel.getToken()
                    }
                )
            }

            WindowSize.MEDIUM -> {
                LoginMediumScreen()
            }

            WindowSize.EXPANDED -> {
                LoginExpandedScreen(
                    userNameValue = viewModel.userName.value,
                    userNameIsError = viewModel.userNameError.value,
                    passwordValue = viewModel.password.value,
                    passwordIsError = viewModel.passwordError.value,
                    loading = login.isLoading,
                    onUserNameChange = { viewModel.userName.value = it },
                    onPasswordChange = { viewModel.password.value = it },
                    onLoginClick = {
                        keyboardController?.hide()
                        viewModel.getToken()
                    }
                )
            }
        }
    }
}
//-------------------------------------------------------------------------------------------------- LoginScreen