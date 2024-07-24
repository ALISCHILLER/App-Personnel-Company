package ui.common.widget.progress

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


//-------------------------------------------------------------------------------------------------- CircularProgressBar
@Composable
fun CircularProgressBar(
    modifier: Modifier,
    percentage: Float,
    fillBrush: Brush,
    backgroundBrush: Brush,
    strokeWidth: Dp
) {
    val v1 = 180f
    val v2 = 180f
    val animatePercentage = remember { Animatable(0.0f, v2) }
    LaunchedEffect(Unit) {
        delay(500)
        animatePercentage.animateTo(
            targetValue = percentage * v2,
            animationSpec = tween(durationMillis = 1500)
        )
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = Modifier.fillMaxWidth().weight(1.0f).padding(10.dp)
        ) {

            val arcHeight = (size.height * 2)

            drawArc(
                brush = backgroundBrush,
                startAngle = v1,
                sweepAngle = v2,
                false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round),
                size = Size(width = size.width, height = arcHeight),
            )

            drawArc(
                brush = fillBrush,
                startAngle = v1,
                sweepAngle = animatePercentage.value,
                false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round),
                size = Size(width = size.width, height = arcHeight)
            )
        }
    }

}
//-------------------------------------------------------------------------------------------------- CircularProgressBar