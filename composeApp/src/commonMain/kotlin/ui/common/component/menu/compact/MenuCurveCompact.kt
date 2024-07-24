package ui.common.component.menu.compact

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import kotlinx.coroutines.launch

//-------------------------------------------------------------------------------------------------- MenuCurveCompact
@Composable
fun MenuCurveCompact(
    modifier: Modifier,
    itemCount: Int,
    itemSelected: Int,
    paddingTop: Float,
    backgroundColors: Color,
    durationMillis: Int
) {
    val scope = rememberCoroutineScope()
    val animateWidth = remember { Animatable(0f, 0f) }
    val animateHeight = remember { Animatable(1.0f, 0.15f) }

    LaunchedEffect(itemSelected) {
        scope.launch {
            animateWidth.animateTo(
                targetValue = itemSelected * 1.0f,
                animationSpec = tween(durationMillis = durationMillis)
            )
        }

        scope.launch {
            animateHeight.animateTo(
                targetValue = 0.15f,
                animationSpec = tween(durationMillis = durationMillis / 2)
            )
            animateHeight.animateTo(
                targetValue = 1.0f,
                animationSpec = tween(durationMillis = durationMillis / 2)
            )
        }
    }

    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val itemWidth = width / itemCount
        val menuStartTop = height * paddingTop
        val circleHalfWidth = menuStartTop * 2.2f
        val widthCenter = (itemWidth * animateWidth.value) - (itemWidth / 2)
        val path = Path().apply {
            moveTo(x = 0f, y = height)
            lineTo(x = 0f, y = menuStartTop)
            lineTo(x = widthCenter - (circleHalfWidth / 2f) - 30, y = menuStartTop)
            cubicTo(
                x1 = widthCenter - (circleHalfWidth / 2f) - 30,
                y1 = menuStartTop,
                x2 = widthCenter - (circleHalfWidth / 2f) - 10,
                y2 = menuStartTop,
                x3 = widthCenter - (circleHalfWidth / 2f) + 5,
                y3 = menuStartTop - 20
            )
            cubicTo(
                x1 = widthCenter - (circleHalfWidth / 2f) + 5,
                y1 = menuStartTop - 20,
                x2 = widthCenter,
                y2 = menuStartTop * (animateHeight.value * -1),
                x3 = widthCenter + (circleHalfWidth / 2f) - 5,
                y3 = menuStartTop - 20
            )
            cubicTo(
                x1 = widthCenter + (circleHalfWidth / 2f) - 5,
                y1 = menuStartTop - 20,
                x2 = widthCenter + (circleHalfWidth / 2f) + 10,
                y2 = menuStartTop,
                x3 = widthCenter + (circleHalfWidth / 2f) + 30,
                y3 = menuStartTop
            )
            lineTo(x = width, y = menuStartTop)
            lineTo(x = width, y = height)
            lineTo(x = 0f, y = height)
            close()
        }
        drawPath(path = path, color = backgroundColors)
    }
}
//-------------------------------------------------------------------------------------------------- MenuCurveCompact