package ui.common.widget.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

//-------------------------------------------------------------------------------------------------- ImageWithCircle
@Composable
fun ImageWithCircle(
    modifier: Modifier,
    circleColor: Color,
    icon: DrawableResource,
    tintColor: Color,
    paddingIcon: Dp
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = circleColor),
        shape = CircleShape
    ) {
        Image(
            modifier = Modifier.padding(paddingIcon).fillMaxSize(),
            painter = painterResource(icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = tintColor)
        )
    }
}
//-------------------------------------------------------------------------------------------------- ImageWithCircle