package ui.common.widget.progress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


//-------------------------------------------------------------------------------------------------- HorizontalProgressBar
@Composable
fun HorizontalProgressBar(
    modifier: Modifier,
    percentage: Float,
    fillBrush: Brush,
    backgroundBrush: Brush
) {
    val v1 = 1.0f
    val animatePercentage = remember { Animatable(0.0f, v1) }
    LaunchedEffect(percentage) {
        delay(300)
        animatePercentage.animateTo(
            targetValue = percentage * v1,
            animationSpec = tween(durationMillis = 1500)
        )
    }

    Box(modifier = modifier) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = backgroundBrush, shape = RoundedCornerShape(20.dp))
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(animatePercentage.value)
                .fillMaxHeight()
                .background(brush = fillBrush, shape = RoundedCornerShape(20.dp))
        )
    }

}
//-------------------------------------------------------------------------------------------------- HorizontalProgressBar