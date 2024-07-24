package ui.common.component.menu.extended

import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.launch
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_chevron
import org.jetbrains.compose.resources.painterResource
import domain.model.MenuItemModel
import ui.theme.Colors
import ui.theme.CornerSizeNormal
import ui.theme.FontSizeNormal
import ui.theme.PaddingLarge
import ui.theme.PaddingNormal
import ui.theme.PaddingSemiLarge
import ui.theme.Peyda

//-------------------------------------------------------------------------------------------------- MenuItemExtended
@Composable
fun MenuItemExtended(
    modifier: Modifier,
    item: MenuItemModel,
    itemIndex: Int,
    itemSelected: Int
) {
    val scope = rememberCoroutineScope()
    val color = remember { Animatable(Colors.text50) }
    var expanded by remember {
        mutableStateOf(false)
    }
    val rotateState = animateFloatAsState(
        targetValue = if (expanded) 90F else 0F, label = "",
    )
    LaunchedEffect(itemSelected) {
        scope.launch {
            color.animateTo(
                targetValue = if (itemSelected == itemIndex) Colors.background100 else Colors.text75,
                animationSpec = tween(durationMillis = 1000)
            )
        }
    }
    val rowModifier = if (itemSelected == itemIndex)
        Modifier
            .fillMaxWidth()
            .background(
                color = Colors.primary100, shape = RoundedCornerShape(
                    CornerSizeNormal
                )
            )
    else
        Modifier.fillMaxWidth()
    Column(
        modifier = modifier
            .clickable {
                if (item.subMenuItems.isNullOrEmpty())
                    item.onClick.invoke()
                else
                    expanded = !expanded
            }
    ) {
        Row(
            modifier = rowModifier
                .padding(PaddingSemiLarge),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            if (!item.subMenuItems.isNullOrEmpty())
                Image(
                    modifier = Modifier.fillMaxWidth(0.06f).aspectRatio(1.0f)
                        .rotate(rotateState.value),
                    contentDescription = null,
                    painter = painterResource(Res.drawable.ic_chevron),
                    colorFilter = ColorFilter.tint(color = color.value),
                )
            Text(
                modifier = Modifier.padding(end = PaddingNormal).weight(1.0f),
                text = item.title,
                fontFamily = Peyda(),
                fontSize = FontSizeNormal,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                textAlign = TextAlign.Right,
                color = color.value
            )
            Image(
                modifier = Modifier.fillMaxWidth(0.12f).aspectRatio(1.0f),
                contentDescription = null,
                painter = painterResource(item.icon),
                colorFilter = ColorFilter.tint(color = color.value)
            )

        }
        item.subMenuItems?.let {
            AnimatedVisibility(
                visible = expanded
            ) {
                MenuSubItemsExtended(
                    modifier = Modifier.padding(end = PaddingLarge).fillMaxWidth(),
                    items = item.subMenuItems,
                    itemSelected = -1
                )
            }
        }
    }
}
//-------------------------------------------------------------------------------------------------- MenuItemExtended