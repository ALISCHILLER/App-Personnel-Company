package ui.common.component.menu.extended

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.theme.CornerSizeNormal

@Composable
fun MenuExtendedFooter(
    modifier: Modifier,
    backgroundColor: Color
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(bottomStart = CornerSizeNormal, bottomEnd = CornerSizeNormal)
            )
    ) {

    }

}