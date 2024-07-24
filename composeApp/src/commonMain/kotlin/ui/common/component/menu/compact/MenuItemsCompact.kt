package ui.common.component.menu.compact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import domain.model.MenuItemModel

@Composable
fun MenuItemsCompact(
    modifier: Modifier,
    items: List<MenuItemModel>,
    paddingTop: Dp,
    itemSelected: Int,
    backgroundColors: Color,
    durationMillis: Int
) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween) {
        items.forEachIndexed { index, item ->
            MenuItemCompact(modifier = Modifier
                .weight(1f),
                paddingTop = paddingTop,
                itemIndex = index,
                item = item,
                itemSelected = itemSelected,
                backgroundColors = backgroundColors,
                durationMillis = durationMillis
            )
        }
    }
}