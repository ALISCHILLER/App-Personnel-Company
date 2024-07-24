package ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ui.common.component.SplashImageComponent
import moe.tlaster.precompose.navigation.Navigator
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.splash_mobile_1
import org.jetbrains.compose.resources.painterResource
import ui.common.component.SplashFooterComponent
import ui.navigation.MyZarRoutManager
import ui.screen.zar.ZarScreen
import ui.theme.Colors
import util.windows_size.WindowSize


//-------------------------------------------------------------------------------------------------- SplashScreen
@Composable
fun SplashScreen(
    navigator: Navigator,
    viewModel: SplashViewModel,
    windowSize: WindowSize,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>
) {

    LaunchedEffect(Unit) {
        viewModel.checkUserLogged()
    }

    val splashStep = viewModel.splashStep
    val userLogged = viewModel.userLogged

    userLogged.data?.let {
        LaunchedEffect(Unit) {
            delay(1500)
            if (!it)
                MyZarRoutManager.gotoLoginScreen(navigator = navigator)
            else
                MyZarRoutManager.gotoHomeScreen(navigator = navigator)
        }
    }

    ZarScreen(
        navigator = navigator,
        message = userLogged.message,
        unAuthorization = userLogged.unAuthorization,
        mySnackBarHostState = mySnackBarHostState,
        snackBarContainerColor = snackBarContainerColor
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(color = Colors.background),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SplashImageComponent(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.7f),
                percentage = splashStep,
                painter = painterResource(Res.drawable.splash_mobile_1),
                progressHeight = 10.dp
            )
            SplashFooterComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f),
                windowSize = windowSize
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- SplashScreen