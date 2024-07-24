package ui.common.component.menu.extended

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ui.common.component.ProfileImage
import domain.model.MenuItemModel
import ui.theme.Colors
import ui.theme.CornerSizeNormal
import ui.theme.FontSizeNormal
import ui.theme.PaddingLarge
import ui.theme.PaddingNormal
import ui.theme.Peyda

//-------------------------------------------------------------------------------------------------- MenuExtendedHeader
@Composable
fun MenuExtendedHeader(
    modifier: Modifier,
    backgroundColor: Color,
    items: List<MenuItemModel>,
    itemSelected: Int
) {
    Column(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(topStart = CornerSizeNormal, topEnd = CornerSizeNormal)
            )
            .padding(PaddingLarge),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(PaddingNormal).fillMaxWidth(),
            text = "MYZAR",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = Colors.primary100,
            textAlign = TextAlign.Center,
            fontFamily = Peyda()
        )
        ProfileImage(
            modifier = Modifier.padding(top = PaddingLarge).fillMaxWidth(0.25f).aspectRatio(1.0f)
        )
        Text(
            modifier = Modifier.padding(top = PaddingNormal).fillMaxWidth(),
            text = "داشبورد",
            fontSize = FontSizeNormal,
            color = Colors.text75,
            fontFamily = Peyda(),
            textAlign = TextAlign.Right
        )
        MenuItemsExtended(
            modifier = Modifier.padding(top = PaddingNormal).fillMaxWidth(),
            items = items,
            itemSelected = itemSelected
        )
    }
}
//-------------------------------------------------------------------------------------------------- MenuExtendedHeader