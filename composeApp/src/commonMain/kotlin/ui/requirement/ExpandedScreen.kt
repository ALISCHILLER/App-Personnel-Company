package ui.requirement

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.Navigator
import ui.common.component.menu.extended.MenuExtended
import ui.common.widget.snackbar.MyZarSnackBar
import ui.navigation.GetNavHost
import ui.theme.Colors
import util.windows_size.WindowSize

//-------------------------------------------------------------------------------------------------- ExpandedScreen
@Composable
fun ExpandedScreen(
    navigator: Navigator,
    windowSize: WindowSize,
    startDestination: String,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>,
    isShowMenu: MutableState<Boolean>,
    backgroundColor: Color
) {
    Row(
        modifier = Modifier.fillMaxSize().background(color = backgroundColor),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {

        Scaffold(
            modifier = Modifier.fillMaxHeight().weight(1.0f),
            snackbarHost = {
                MyZarSnackBar(
                    snackBarHostState = mySnackBarHostState,
                    containerColor = snackBarContainerColor.value
                )
            }
        ) {
            Surface(
                modifier = Modifier.padding(it).fillMaxSize(),
                color = backgroundColor
            ) {
                GetNavHost(
                    windowSize = windowSize,
                    navigator = navigator,
                    startDestination = startDestination,
                    mySnackBarHostState = mySnackBarHostState,
                    snackBarContainerColor = snackBarContainerColor,
                    isShowMenu = isShowMenu,

                )
            }
        }
        if (isShowMenu.value)
            MenuExtended(
                navigator = navigator,
                modifier = Modifier.fillMaxHeight().weight(0.4f)
            )
    }
}
//-------------------------------------------------------------------------------------------------- ExpandedScreen