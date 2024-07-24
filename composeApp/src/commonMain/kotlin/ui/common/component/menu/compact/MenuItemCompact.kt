package ui.common.component.menu.compact

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import domain.model.MenuItemModel
import ui.theme.Colors
import ui.theme.FontSizeNormal
import ui.theme.Peyda
import util.ex.toDp

@Composable
fun MenuItemCompact(
    modifier: Modifier,
    paddingTop: Dp,
    item: MenuItemModel,
    itemIndex: Int,
    itemSelected: Int,
    backgroundColors: Color,
    durationMillis: Int
) {
    val scope = rememberCoroutineScope()
    val animateHeight = remember { Animatable(0.0f, 1.0f) }
    val textColor = remember { androidx.compose.animation.Animatable(Colors.text50) }
    val iconColor = remember { androidx.compose.animation.Animatable(Colors.text50) }
    val circleColor = remember { androidx.compose.animation.Animatable(Colors.background100) }
    LaunchedEffect(itemSelected) {
        scope.launch {
            animateHeight.animateTo(
                targetValue = if (itemSelected == itemIndex) 0.0f else 1.0f,
                animationSpec = tween(durationMillis = (durationMillis * 1.4).toInt())
            )
        }
        scope.launch {
            textColor.animateTo(
                targetValue = if (itemSelected == itemIndex) Colors.primary100 else Colors.text50,
                animationSpec = tween(durationMillis = (durationMillis * 0.8).toInt()))
        }
        scope.launch {
            iconColor.animateTo(
                targetValue = if (itemSelected == itemIndex) backgroundColors else Colors.text50,
                animationSpec = tween(durationMillis = (durationMillis * 0.8).toInt()))
        }
        scope.launch {
            circleColor.animateTo(
                targetValue = if (itemSelected == itemIndex) Colors.primary100 else backgroundColors,
                animationSpec = tween(durationMillis = (durationMillis * 0.8).toInt()))
        }
    }
    Surface (
        modifier = modifier.padding(horizontal = 5.dp).fillMaxHeight(),
        color = Color.Transparent
    ) {
        val paddingPX  = LocalDensity.current.run { paddingTop.toPx() }
        val bottomPaddingPX  = LocalDensity.current.run { 10.dp.toPx() }
        val iconPaddingPX  = LocalDensity.current.run { 15.dp.toPx() }
        Column(
            modifier = Modifier
                .padding(
                    top = (paddingPX * animateHeight.value).toDp(),
                    bottom = (bottomPaddingPX * (1.0f - animateHeight.value)).toDp()
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp,
                        bottom = (10.0f * (1.0f - animateHeight.value)).toDp()
                    )
                    .weight(1.0f)
                    .aspectRatio(1.0f)
                    .background(shape = CircleShape, color = circleColor.value)
                    .padding((iconPaddingPX * (1.0f - animateHeight.value)).toDp())
                    .clickable {
                               item.onClick.invoke()
                    },
                painter = painterResource(item.icon),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = iconColor.value)
            )
            Text(
                modifier = Modifier,
                text = item.title,
                fontFamily = Peyda(),
                fontSize = FontSizeNormal,
                fontWeight = FontWeight.SemiBold,
                color = textColor.value,
                maxLines = 1
            )
        }
    }
}