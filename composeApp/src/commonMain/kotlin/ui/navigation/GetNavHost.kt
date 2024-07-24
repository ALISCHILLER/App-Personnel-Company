package ui.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import org.koin.core.parameter.parametersOf
import ui.screen.cartable.CarTableScreen
import ui.screen.home.HomeScreen
import ui.screen.home.HomeViewModel
import ui.screen.login.LoginScreen
import ui.screen.login.LoginViewModel
import ui.screen.setting.SettingScreen
import ui.screen.splash.SplashScreen
import ui.screen.splash.SplashViewModel
import util.windows_size.WindowSize

@Composable
fun GetNavHost(
    modifier: Modifier=Modifier,
    windowSize: WindowSize,
    navigator: Navigator,
    startDestination: String,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>,
    isShowMenu: MutableState<Boolean>
) = NavHost(
    navigator = navigator,
    navTransition = NavTransition(),
    initialRoute = startDestination,
    modifier = modifier
){

    //--------------------------------------------------------------------------------------
    scene(
        route = MyZarScreens.SplashScreen.name,
        navTransition = NavTransition()
    ) {
        isShowMenu.value = false
        val viewModel = koinViewModel(vmClass = SplashViewModel::class) { parametersOf() }
        SplashScreen(
            navigator = navigator,
            viewModel = viewModel,
            windowSize = windowSize,
            mySnackBarHostState = mySnackBarHostState,
            snackBarContainerColor = snackBarContainerColor
        )
    }
    //--------------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------------
    scene(
        route = MyZarScreens.LoginScreen.name,
        navTransition = NavTransition()
    ) {
        isShowMenu.value = false
        val viewModel = koinViewModel(vmClass = LoginViewModel::class){ parametersOf() }
        LoginScreen(
            navigator = navigator,
            viewModel = viewModel,
            windowSize = windowSize,
            mySnackBarHostState = mySnackBarHostState,
            snackBarContainerColor = snackBarContainerColor
        )
    }
    //--------------------------------------------------------------------------------------



    //--------------------------------------------------------------------------------------
    scene(
        route = MyZarScreens.HomeScreen.name,
        navTransition = NavTransition()
    ) {
        isShowMenu.value = true
        val viewModel = koinViewModel(vmClass = HomeViewModel::class){ parametersOf() }
        HomeScreen(
            navigator = navigator,
            mySnackBarHostState = mySnackBarHostState,
            snackBarContainerColor = snackBarContainerColor,
            windowSize = windowSize,
            viewModel = viewModel
        )
    }
    //--------------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------------
    scene(
        route = MyZarScreens.SettingScreen.name,
        navTransition = NavTransition()
    ) {
        isShowMenu.value = true
        SettingScreen(
            navigator = navigator,
            mySnackBarHostState = mySnackBarHostState,
            snackBarContainerColor = snackBarContainerColor
        )
    }
    //--------------------------------------------------------------------------------------


    //--------------------------------------------------------------------------------------
    scene(
        route = MyZarScreens.CarTableScreen.name,
        navTransition = NavTransition()
    ) {
        isShowMenu.value = true
        CarTableScreen(
            navigator = navigator,
            mySnackBarHostState = mySnackBarHostState,
            snackBarContainerColor = snackBarContainerColor
        )
    }
    //--------------------------------------------------------------------------------------
}