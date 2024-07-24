package ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import domain.model.AppModel
import domain.model.enums.AppRowType
import ui.common.component.row.app.AppRow
import ui.common.component.slider.HorizontalSlider
import ui.theme.PaddingNormal

//-------------------------------------------------------------------------------------------------- HomeExpandedScreen
@Composable
fun HomeExpandedScreen(
    firstApps: List<AppModel>,
    towApps : List<AppModel>,
    threeApps : List<AppModel>,
) {

    Column(modifier = Modifier.fillMaxSize()) {

        HorizontalSlider(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f),
        )

        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(PaddingNormal),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    AppRow(
                        modifier = Modifier.padding(PaddingNormal).fillMaxSize(),
                        apps = firstApps,
                        appRowType = AppRowType.WithDescription
                    )
                }
                item {
                    AppRow(
                        modifier = Modifier.padding(PaddingNormal).fillMaxSize(),
                        apps = towApps,
                        appRowType = AppRowType.Normal
                    )
                }

                item {
                    AppRow(
                        modifier = Modifier.padding(PaddingNormal).fillMaxSize(),
                        apps = threeApps,
                        appRowType = AppRowType.Normal
                    )
                }


            }
        }

    }

}
//-------------------------------------------------------------------------------------------------- HomeExpandedScreen