package ui.common.component.menu.compact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_category
import myzar.composeapp.generated.resources.ic_home
import myzar.composeapp.generated.resources.ic_setting
import domain.model.MenuItemModel
import ui.navigation.MyZarRoutManager
import ui.navigation.MyZarScreens
import ui.theme.Colors
import util.ex.toDp

@Composable
fun MenuCompact(
    navigator: Navigator,
    modifier: Modifier,
    height: Dp,
    backgroundColor: Color
) {

    val menuItems = listOf(
        MenuItemModel(
            title = "دسترسی ها",
            icon = Res.drawable.ic_category,
            screen = MyZarScreens.CarTableScreen,
            onClick = {
                MyZarRoutManager.gotoCarTableScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "خانه",
            icon = Res.drawable.ic_home,
            screen = MyZarScreens.HomeScreen,
            onClick = {
                MyZarRoutManager.gotoHomeScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        )
    )

    val itemSelected = remember { mutableStateOf(1) }
    val paddingTop = 0.35f
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            navigator.currentEntry.collectLatest {backStackEntry ->
                val screen = MyZarScreens.fromRoute(backStackEntry?.route?.route)
                itemSelected.value = menuItems.indexOfFirst { it.screen == screen } + 1
            }
        }
    }

    val curveBackgroundColor = Colors.background100
    val durationMillis = 1000
    Box(modifier = modifier.height(height).background(color = backgroundColor)) {
        MenuCurveCompact(
            modifier = Modifier.fillMaxSize(),
            itemCount = menuItems.size,
            itemSelected = itemSelected.value,
            paddingTop = paddingTop,
            backgroundColors = curveBackgroundColor,
            durationMillis = durationMillis
        )

        val heightPX  = LocalDensity.current.run { height.toPx() }
        MenuItemsCompact(
            modifier = modifier.fillMaxSize(),
            items = menuItems,
            itemSelected = itemSelected.value - 1,
            paddingTop = (heightPX * (paddingTop + 0.05f)).toDp(),
            backgroundColors = curveBackgroundColor,
            durationMillis = durationMillis
        )

    }

}