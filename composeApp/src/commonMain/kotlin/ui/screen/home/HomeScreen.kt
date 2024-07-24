package ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.navigation.Navigator
import ui.common.component.ProfileImage
import ui.common.component.slider.VerticalSlider
import ui.screen.zar.ZarScreen
import ui.theme.PaddingLarge
import util.windows_size.WindowSize

//-------------------------------------------------------------------------------------------------- HomeScreen
@Composable
fun HomeScreen(
    navigator: Navigator,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>,
    windowSize: WindowSize,
    viewModel: HomeViewModel
) {
    val firstApps = viewModel.getFirstApps()
    val towApps = viewModel.getTowApps()
    val threeApps = viewModel.getThreeApps()
    ZarScreen(
        navigator = navigator,
        mySnackBarHostState = mySnackBarHostState,
        snackBarContainerColor = snackBarContainerColor
    ) {
        when(windowSize) {
            WindowSize.COMPACT -> {
                HomeCompactScreen(
                    firstApps = firstApps,
                    towApps = towApps,
                    threeApps = threeApps,
                )
            }
            WindowSize.MEDIUM -> {

            }
            WindowSize.EXPANDED ->{
                HomeExpandedScreen(
                    firstApps = firstApps,
                    towApps = towApps,
                    threeApps = threeApps,
                )
            }
        }
    }

}
//-------------------------------------------------------------------------------------------------- HomeScreen