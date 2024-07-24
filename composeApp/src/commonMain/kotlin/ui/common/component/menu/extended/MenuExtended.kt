package ui.common.component.menu.extended

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
import ui.theme.PaddingUltraLarge

//-------------------------------------------------------------------------------------------------- MenuExtended
@Composable
fun MenuExtended(
    navigator: Navigator,
    modifier: Modifier
) {
    val menuItems = listOf(
        MenuItemModel(
            title = "خانه",
            icon = Res.drawable.ic_home,
            screen = MyZarScreens.HomeScreen,
            onClick = {
                MyZarRoutManager.gotoHomeScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "دسترسی ها",
            icon = Res.drawable.ic_category,
            screen = MyZarScreens.CarTableScreen,
            subMenuItems = listOf(
                MenuItemModel(
                    title = "دسترسی اول",
                    icon = Res.drawable.ic_category,
                    screen = MyZarScreens.CarTableScreen,
                    onClick = {
                        MyZarRoutManager.gotoCarTableScreen(navigator = navigator)
                    }
                ),
                MenuItemModel(
                    title = "دسترسی دوم",
                    icon = Res.drawable.ic_category,
                    screen = MyZarScreens.CarTableScreen,
                    subMenuItems = listOf(
                        MenuItemModel(
                            title = "دسترسی دوم اول",
                            icon = Res.drawable.ic_category,
                            screen = MyZarScreens.CarTableScreen,
                            onClick = {
                                MyZarRoutManager.gotoCarTableScreen(navigator = navigator)
                            }
                        ),
                        MenuItemModel(
                            title = "دسترسی دوم دوم",
                            icon = Res.drawable.ic_category,
                            screen = MyZarScreens.CarTableScreen,
                            onClick = {
                                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
                            }
                        )
                    ),
                    onClick = { }
                )
            ),
            onClick = { }
        ),
        MenuItemModel(
            title = "تنظیمات",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "1تنظیمات",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            subMenuItems = listOf(
                MenuItemModel(
                    title = "دسترسی اول",
                    icon = Res.drawable.ic_category,
                    screen = MyZarScreens.CarTableScreen,
                    onClick = {
                        MyZarRoutManager.gotoCarTableScreen(navigator = navigator)
                    }
                ),
                MenuItemModel(
                    title = "دسترسی دوم",
                    icon = Res.drawable.ic_category,
                    screen = MyZarScreens.CarTableScreen,
                    subMenuItems = listOf(
                        MenuItemModel(
                            title = "دسترسی دوم اول",
                            icon = Res.drawable.ic_category,
                            screen = MyZarScreens.CarTableScreen,
                            onClick = {
                                MyZarRoutManager.gotoCarTableScreen(navigator = navigator)
                            }
                        ),
                        MenuItemModel(
                            title = "دسترسی دوم دوم",
                            icon = Res.drawable.ic_category,
                            screen = MyZarScreens.CarTableScreen,
                            onClick = {
                                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
                            }
                        )
                    ),
                    onClick = { }
                )
            ),
            onClick = {}
        ),
        MenuItemModel(
            title = "2تنظیمات",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "3تنظیمات",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات4",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "5تنظیمات",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات6",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات7",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات8",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات9",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        ),
        MenuItemModel(
            title = "تنظیمات10",
            icon = Res.drawable.ic_setting,
            screen = MyZarScreens.SettingScreen,
            onClick = {
                MyZarRoutManager.gotoSettingScreen(navigator = navigator)
            }
        )
    )

    val itemSelected = remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            navigator.currentEntry.collectLatest {backStackEntry ->
                val screen = MyZarScreens.fromRoute(backStackEntry?.route?.route)
                itemSelected.value = menuItems.indexOfFirst { it.screen == screen } + 1

            }
        }
    }
    Column(
        modifier = modifier.padding(PaddingUltraLarge),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        val backgroundColor = Colors.background100
        MenuExtendedHeader(
            modifier = Modifier.fillMaxWidth().weight(1.0f),
            backgroundColor = backgroundColor,
            items = menuItems,
            itemSelected = itemSelected.value - 1
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(1.5.dp).background(color = Colors.text25))
        MenuExtendedFooter(
            modifier = Modifier,
            backgroundColor = backgroundColor
        )

    }
}
//-------------------------------------------------------------------------------------------------- MenuExtended