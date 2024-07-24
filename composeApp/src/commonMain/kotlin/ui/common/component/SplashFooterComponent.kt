package ui.common.component

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay
import ui.theme.Colors
import util.windows_size.WindowSize

@Composable
fun SplashFooterComponent(
    modifier: Modifier,
    windowSize: WindowSize
) {
    Box(
        modifier = modifier
    ) {
        val target = when(windowSize) {
            WindowSize.COMPACT -> -0.15f
            else -> -0.05f
        }
        val animatePercentage = remember { Animatable(1.0f, target) }
        val color = remember { Animatable(Colors.GrayLight) }
        LaunchedEffect(Unit) {
            delay(1000)
            animatePercentage.animateTo(
                targetValue = target,
                animationSpec = tween(durationMillis = 1500)
            )
        }

        LaunchedEffect(Unit) {
            delay(1000)
            color.animateTo(Colors.SecondaryLight, animationSpec = tween(1500))
        }

        val rotate = 90 * (1.0f - animatePercentage.value)
        Column(
            Modifier
                .fillMaxSize()
                .graphicsLayer {
                    translationX = (size.width - size.height / 2) * animatePercentage.value
                    translationY = size.height / 2 * (1.0f - animatePercentage.value)
                },
            verticalArrangement = Arrangement.Top
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .aspectRatio(ratio = 1.0f)
                    .rotate(if (rotate > 90) 90f else rotate)
            ) {
                val path = Path().apply {
                    arcTo(
                        rect = Rect(Offset(x = size.width / 2, y = 0f), size),
                        startAngleDegrees = 90f,
                        sweepAngleDegrees = 180f,
                        forceMoveTo = false
                    )
                }
                drawPath(path = path, color = color.value)
            }
        }
    }
}