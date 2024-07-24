package ui.common.component.menu.extended

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.MenuItemModel
import ui.theme.PaddingLarge

//-------------------------------------------------------------------------------------------------- MenuItemsExtended
@Composable
fun MenuItemsExtended(
    modifier: Modifier,
    items: List<MenuItemModel>,
    itemSelected: Int
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(
            items = items,
            key = { index, _ -> index}
        ) { index, item ->
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