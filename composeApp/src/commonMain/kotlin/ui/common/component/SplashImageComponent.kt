package ui.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.common.widget.progress.HorizontalProgressBar
import ui.theme.Colors
import ui.theme.CornerSizeOverExtraLarge
import ui.theme.FontSizeLarge
import ui.theme.FontSizeNormal
import ui.theme.Peyda
import util.MyZarText


//-------------------------------------------------------------------------------------------------- SplashImageComponent
@Composable
fun SplashImageComponent(
    modifier: Modifier,
    percentage: Float,
    painter: Painter,
    progressHeight: Dp
) {
    Box(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        bottomStart = CornerSizeOverExtraLarge,
                        bottomEnd = CornerSizeOverExtraLarge
                    )
                ),
            painter = painter,
            contentScale = ContentScale.FillBounds,
            contentDescription = ""
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 2.dp),
                    text = MyZarText.myZarPersian,
                    fontSize = FontSizeLarge,
                    fontFamily = Peyda(),
                    fontWeight = FontWeight.Bold,
                    color = Colors.White
                )

                Text(
                    text = MyZarText.splashText,
                    fontSize = FontSizeNormal,
                    fontFamily = Peyda(),
                    fontWeight = FontWeight.Normal,
                    color = Colors.White,
                )
            }
            HorizontalProgressBar(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .height(progressHeight)
                    .background(color = Colors.White, shape = RoundedCornerShape(20.dp))
                    .padding(2.dp),
                percentage = percentage,
                fillBrush = Brush.horizontalGradient(
                    colors = listOf(
                        Colors.background,
                        Colors.secondary
                    )
                ),
                backgroundBrush = Brush.horizontalGradient(
                    colors = listOf(
                        Colors.White,
                        Colors.White
                    )
                )
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- SplashImageComponent