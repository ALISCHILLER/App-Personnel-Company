package ui.common.component.menu.extended

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.MenuItemModel
import ui.theme.PaddingLarge

//-------------------------------------------------------------------------------------------------- MenuItemsExtended
@Composable
fun MenuSubItemsExtended(
    modifier: Modifier,
    items: List<MenuItemModel>,
    itemSelected: Int
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEachIndexed { index, item ->
            MenuItemExtended(
                modifier = Modifier.padding(top = PaddingLarge).fillMaxWidth(),
                item = item,
                itemIndex = index,
                itemSelected = itemSelected
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- MenuItemsExtended