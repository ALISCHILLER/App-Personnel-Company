package ui.theme


import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.peyda_bold
import myzar.composeapp.generated.resources.peyda_medium
import myzar.composeapp.generated.resources.peyda_regular
import myzar.composeapp.generated.resources.peyda_semi_bold
import myzar.composeapp.generated.resources.vazir_medium
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.ExperimentalResourceApi


@OptIn(ExperimentalResourceApi::class)
@Composable
fun Peyda(): FontFamily {
    return FontFamily(
        Font(resource = Res.font.peyda_regular, weight = FontWeight.Normal),
        Font(resource = Res.font.peyda_medium, weight = FontWeight.Normal),
        Font(resource = Res.font.peyda_semi_bold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.peyda_bold, weight = FontWeight.Bold)
    )
}


@Composable
fun Vazir():FontFamily{
    return  FontFamily(
        Font(resource = Res.font.vazir_medium, weight = FontWeight.Normal),
        Font(resource = Res.font.vazir_medium, weight = FontWeight.Normal),
        Font(resource = Res.font.vazir_medium, weight = FontWeight.SemiBold),
        Font(resource = Res.font.vazir_medium, weight = FontWeight.Bold),
    )
}
