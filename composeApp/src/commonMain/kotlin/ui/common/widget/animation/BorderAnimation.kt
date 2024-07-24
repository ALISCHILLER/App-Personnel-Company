package ui.common.widget.animation

import androidx.compose.animation.core.EaseOutSine
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import ui.theme.PaddingSmall

@Composable
fun BorderAnimation(
    modifier: Modifier,
    cardShape: RoundedCornerShape,
    borderWidth: Dp,
    loading: Boolean,
    backgroundColor: Color,
    borderColors: List<Color>,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = EaseOutSine
            )
        ),
        label = ""
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .wrapContentSize()
                .padding(PaddingSmall)
                .clip(cardShape)
                .padding(borderWidth)
                .drawWithContent {
                    rotate(
                        if (loading) {
                            rotate
                        } else {
                            0f
                        }
                    ) {
                        drawCircle(
                            brush = if (loading) {
                                Brush.sweepGradient(
                                    borderColors
                                )
                            } else {
                                Brush.linearGradient(
                                    listOf(
                                        backgroundColor,
                                        backgroundColor
                                    )
                                )
                            },
                            radius = size.width,
                            blendMode = BlendMode.SrcIn,
                        )
                    }
                    drawContent()
                }
                .background(backgroundColor, cardShape)
        ) {
            content()
        }
    }
}