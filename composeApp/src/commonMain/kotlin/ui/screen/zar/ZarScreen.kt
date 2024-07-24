package ui.screen.zar

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import ui.common.widget.snackbar.showMessage
import domain.model.ErrorModel
import domain.model.enums.EnumError
import kotlinx.coroutines.delay
import moe.tlaster.precompose.navigation.Navigator
import ui.navigation.MyZarRoutManager
import ui.theme.Colors

//-------------------------------------------------------------------------------------------------- ZarScreen
@Composable
fun ZarScreen(
    navigator: Navigator,
    message: ErrorModel? = null,
    unAuthorization: Boolean = false,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>,
    content: @Composable () -> Unit
) {

    val myCoroutineScope = rememberCoroutineScope()
    if (unAuthorization) {
        LaunchedEffect(Unit) {
            delay(1500)
            MyZarRoutManager.gotoLoginScreen(navigator = navigator)
        }
    }
    if (message != null)
        LaunchedEffect(Unit) {
            snackBarContainerColor.value = when (message.type) {
                EnumError.Done -> Colors.Done
                EnumError.Error -> Colors.Error
                EnumError.Warning -> Colors.Warning
            }
            showMessage(
                coroutineScope = myCoroutineScope,
                snackBarHostState = mySnackBarHostState,
                message = message.message,
            )
        }
    content.invoke()
}
//-------------------------------------------------------------------------------------------------- ZarScreen
