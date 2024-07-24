package ui.screen.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.navigation.Navigator
import ui.screen.zar.ZarScreen

//-------------------------------------------------------------------------------------------------- SettingScreen
@Composable
fun SettingScreen(
    navigator: Navigator,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>
) {

    ZarScreen(
        navigator = navigator,
        mySnackBarHostState = mySnackBarHostState,
        snackBarContainerColor = snackBarContainerColor
    ) {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f).background(Color.Cyan)) {

        }
    }

}
//-------------------------------------------------------------------------------------------------- SettingScreen