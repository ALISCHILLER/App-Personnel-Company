package ui.common.component.row.app.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import domain.model.AppModel
import org.jetbrains.compose.resources.painterResource
import ui.theme.Colors
import ui.theme.*
import ui.theme.Peyda

@Composable
fun AppNormalItem(
    modifier: Modifier,
    app: AppModel
) {
    Card(
        modifier = Modifier

            .padding(PaddingNormal),
        colors = CardDefaults.cardColors(containerColor = Colors.background100),
        shape = RoundedCornerShape(CornerSizeUltraLarge)
    ) {
        Row(
            modifier = Modifier
                .size(width = 140.dp, height = 100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Image(
                modifier = Modifier.padding(PaddingSmall).size(30.dp,30.dp),
                painter = painterResource(app.icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = Colors.primary100)
            )
            Text(
                text = app.title,
                fontSize = FontSizeNormal,
                fontFamily = Peyda(),
                textAlign = TextAlign.Justify,
                maxLines= 2
            )

        }
    }
}