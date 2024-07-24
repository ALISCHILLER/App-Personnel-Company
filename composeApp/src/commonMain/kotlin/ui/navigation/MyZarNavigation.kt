package ui.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator
import ui.requirement.CompactScreen
import ui.requirement.ExpandedScreen
import ui.theme.Colors
import util.windows_size.WindowSize

//-------------------------------------------------------------------------------------------------- MyZarNavigation
@Composable
fun MyZarNavigation(
    windowSize: WindowSize,
    windowWidth: Dp,
) {
    val backgroundColor = Colors.background75
    val isShowMenu = remember { mutableStateOf(false) }
    val mySnackBarHostState = remember { SnackbarHostState() }
    val snackBarContainerColor = remember {
        mutableStateOf(Colors.Warning)
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        PreComposeApp {
            val navigator = rememberNavigator()
            val startDestination = MyZarScreens.HomeScreen.name
            when (windowSize) {
                WindowSize.COMPACT -> {
                    CompactScreen(
                        navigator = navigator,
                        windowSize = windowSize,
                        startDestination = startDestination,
                        mySnackBarHostState = mySnackBarHostState,
                        snackBarContainerColor = snackBarContainerColor,
                        isShowMenu = isShowMenu,
                        backgroundColor = backgroundColor,
                        windowWidth = windowWidth
                    )
                }

                else -> {
                    ExpandedScreen(
                        navigator = navigator,
                        windowSize = windowSize,
                        startDestination = startDestination,
                        mySnackBarHostState = mySnackBarHostState,
                        snackBarContainerColor = snackBarContainerColor,
                        isShowMenu = isShowMenu,
                        backgroundColor = backgroundColor
                    )
                }
            }
        }
    }
}
//-------------------------------------------------------------------------------------------------- MyZarNavigation


