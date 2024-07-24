package ui.common.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.solid_white
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MyZarLogo(
    modifier: Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(Res.drawable.solid_white),
        contentDescription = ""
    )
}