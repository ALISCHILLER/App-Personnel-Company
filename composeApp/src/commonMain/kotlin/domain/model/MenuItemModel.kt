package domain.model

import org.jetbrains.compose.resources.DrawableResource
import ui.navigation.MyZarScreens

data class MenuItemModel(
    val title: String,
    val icon: DrawableResource,
    val screen: MyZarScreens,
    val subMenuItems: List<MenuItemModel>? = null,
    val onClick: () -> Unit
)
