package ui.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import ui.common.widget.image.LoadAndCacheImage
import ui.theme.Colors
import ui.theme.CornerSizeExtraLarge
import ui.theme.PaddingLarge

//-------------------------------------------------------------------------------------------------- ProfileImage
@Composable
fun ProfileImage(
    modifier: Modifier
) {
    val imageUrl = "https://axprint.com/blog/wp-content/uploads/2020/10/girl4.jpg"

    Column(
        modifier = modifier
            .background(
                color = Colors.background25,
                shape = RoundedCornerShape(CornerSizeExtraLarge)
            )
            .padding(PaddingLarge)
    ) {

        LoadAndCacheImage(
            modifier = Modifier.fillMaxSize().clip(CircleShape),
            imageLink = imageUrl,
            token = ""
        )
    }
}
//-------------------------------------------------------------------------------------------------- ProfileImage