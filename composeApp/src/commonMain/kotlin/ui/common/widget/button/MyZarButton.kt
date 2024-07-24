package ui.common.widget.button

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import ui.common.widget.animation.BorderAnimation
import ui.theme.Colors.Companion.Dark
import ui.theme.Colors.Companion.Dark25
import ui.theme.Colors.Companion.secondary
import ui.theme.CornerSizeNormal
import ui.theme.CornerSizeOverExtraLarge
import ui.theme.FontSizeLarge
import ui.theme.PaddingSmall
import ui.theme.Peyda

@Composable
fun MyZarButton(
    modifier: Modifier,
    text: String,
    enabled: Boolean,
    loading: Boolean,
    onClick: () -> Unit
) {
/*    val circleColors = listOf(
        Color(0xFF02fdf9),
        Color(0xFF00a3ff),
        Color(0xFFff00ab),
        Color(0xFFff5e00),
        Color(0xFFffba00),
        Color(0xFF9efb04),
        Color(0xFF0eff00),
        Color(0xFF00ffb9),
    )*/
    val circleColors = listOf(
        Color(0xFFf0f1ff),
        Color(0xFFc5caff),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),
        Color(0xFFff5331),

    )
    BorderAnimation(
        modifier = modifier,
        cardShape = RoundedCornerShape(CornerSizeOverExtraLarge),
        borderWidth = PaddingSmall,
        loading = loading,
        backgroundColor = secondary,
        borderColors = circleColors,
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            shape = RoundedCornerShape(CornerSizeOverExtraLarge),
            colors = ButtonDefaults.buttonColors(
                contentColor = secondary,
                containerColor = secondary,
                disabledContainerColor = Dark25,
                disabledContentColor = Dark25
            ),
            onClick = {
                if (!loading)
                    onClick.invoke()
            }
        ) {
            Text(
                modifier = Modifier.padding(PaddingSmall),
                text = text,
                fontSize = FontSizeLarge,
                fontFamily = Peyda(),
                fontWeight = FontWeight.SemiBold,
                color = Dark
            )
        }
    }
}
