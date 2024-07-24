package ui.common.component.topBarMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.avatar
import myzar.composeapp.generated.resources.ic_notification
import org.jetbrains.compose.resources.painterResource
import ui.common.component.customdrawer.CustomDrawerState
import ui.common.component.customdrawer.opposite
import ui.theme.Colors
import ui.theme.FontSizeNormal
import ui.theme.FontSizeUltraLarge
import ui.theme.PaddingLarge
import ui.theme.PaddingSmall
import ui.theme.Peyda
import ui.theme.Vazir

@Composable
fun TopBarComponent(
    modifier: Modifier = Modifier,
    drawerState: CustomDrawerState,
    onDrawerClick: (CustomDrawerState) -> Unit
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Row(
            modifier = modifier
                .padding(horizontal = 5.dp, vertical = 6.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        onDrawerClick(drawerState.opposite())
                    },

                colors = CardDefaults.cardColors(containerColor = Colors.White),
                shape = RoundedCornerShape(12.dp),
            ) {
                Image(
                    modifier = Modifier.padding(PaddingSmall).fillMaxSize(),
                    painter = painterResource(Res.drawable.avatar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Row {
                Text(
                    "سلام محمد",
                    fontSize = FontSizeUltraLarge,
                    fontFamily = Vazir(),
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Justify
                )
            }

            Card(
                modifier = Modifier
                    .size(40.dp),
                colors = CardDefaults.cardColors(containerColor = Colors.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Image(
                    modifier = Modifier.padding(PaddingLarge).fillMaxSize(),
                    painter = painterResource(Res.drawable.ic_notification),
                    contentDescription = null,
//                    colorFilter = ColorFilter.tint(color = Colors.primary100),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}