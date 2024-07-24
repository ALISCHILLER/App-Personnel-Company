package ui.common.component.row.app

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import domain.model.AppModel
import domain.model.enums.AppRowType
import kotlinx.coroutines.launch
import ui.common.component.row.app.item.AppNormalItem
import ui.common.component.row.app.item.AppSeparateIconItem
import ui.common.component.row.app.item.AppWithDescriptionItem

//-------------------------------------------------------------------------------------------------- AppRow
@Composable
fun AppRow(
    modifier: Modifier,
    appRowType: AppRowType,
    apps: List<AppModel>,
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberLazyListState()

    LazyRow(
        state = scrollState,
        modifier = modifier.draggable(
            orientation = Orientation.Horizontal,
            state = rememberDraggableState {delta ->
                coroutineScope.launch {
                    scrollState.scrollBy(delta)
                }
            }
        ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(
            items = apps
        ) { item ->
            when(appRowType) {
                AppRowType.WithDescription -> AppWithDescriptionItem(
                    app = item
                )
                AppRowType.SeparateIcon -> AppSeparateIconItem(
                    modifier = modifier,
                    app = item
                )
                AppRowType.Normal -> AppNormalItem(
                    modifier = modifier,
                    app = item
                )
            }
        }

    }
}
//-------------------------------------------------------------------------------------------------- AppRow