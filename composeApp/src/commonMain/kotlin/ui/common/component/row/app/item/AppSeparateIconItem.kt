package ui.common.component.row.app.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import ui.theme.CornerSizeUltraLarge
import ui.theme.FontSizeNormal
import ui.theme.PaddingLarge
import ui.theme.PaddingNormal
import ui.theme.Peyda

@Composable
fun AppSeparateIconItem(
    modifier: Modifier,
    app: AppModel
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Card(
            modifier = Modifier.size(40.dp),
            colors = CardDefaults.cardColors(containerColor = Colors.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                modifier = Modifier.padding(PaddingLarge).fillMaxSize(),
                painter = painterResource(app.icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = Colors.primary100)
            )
        }

        Text(
            text = app.title,
            fontSize = FontSizeNormal,
            fontFamily = Peyda(),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Justify
            )
    }

}