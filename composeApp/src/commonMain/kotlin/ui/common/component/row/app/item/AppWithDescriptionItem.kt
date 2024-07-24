package ui.common.component.row.app.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import domain.model.AppModel
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_send
import ui.common.widget.image.ImageWithCircle
import ui.theme.Colors
import ui.theme.CornerSizeUltraLarge
import ui.theme.FontSizeLarge
import ui.theme.FontSizeNormal
import ui.theme.PaddingLarge
import ui.theme.PaddingNormal
import ui.theme.Peyda


//-------------------------------------------------------------------------------------------------- AppWithDescriptionItem
@Composable
fun AppWithDescriptionItem(
    app: AppModel
) {
    Card(
        modifier = Modifier.padding(PaddingNormal),
        colors = CardDefaults.cardColors(containerColor = Colors.background100),
        shape = RoundedCornerShape(CornerSizeUltraLarge)
    ) {
        Column(
            modifier = Modifier.padding(PaddingLarge).size(width = 100.dp, height = 140.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = app.title,
                fontSize = FontSizeLarge,
                fontFamily = Peyda(),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Right
            )

            Text(
                modifier = Modifier.padding(top = PaddingLarge).fillMaxWidth().weight(weight = 1.0f),
                text = app.description,
                fontSize = FontSizeNormal,
                fontFamily = Peyda(),
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify
            )

            Row(
                modifier = Modifier.padding(top = PaddingLarge).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                ImageWithCircle(
                    modifier = Modifier.size(40.dp),
                    circleColor = Colors.background50,
                    icon = Res.drawable.ic_send,
                    tintColor = Colors.primary100,
                    paddingIcon = PaddingLarge
                )

                ImageWithCircle(
                    modifier = Modifier.size(40.dp),
                    circleColor = Colors.background50,
                    icon = app.icon,
                    tintColor = Colors.primary100,
                    paddingIcon = PaddingLarge
                )

            }
        }
    }
}
//-------------------------------------------------------------------------------------------------- AppWithDescriptionItem