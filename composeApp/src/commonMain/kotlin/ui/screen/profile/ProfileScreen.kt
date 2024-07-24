package ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_profile
import myzar.composeapp.generated.resources.image_profile
import org.jetbrains.compose.resources.painterResource
import ui.common.component.expandable.ExpandableUnderLineCard
import ui.theme.Colors
import ui.theme.Vazir

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .padding(horizontal = 4.dp)
                .fillMaxSize()

        ) {
            Surface(
                modifier = Modifier
                    .size(154.dp)
                    .padding(5.dp),
                shape = CircleShape,
                border = BorderStroke(0.5.dp, Color.LightGray),
                tonalElevation = 4.dp,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
            ) {
                Image(
                    painter = painterResource(Res.drawable.image_profile),
                    contentDescription = "profile image",
                    modifier = modifier.size(135.dp),
                    contentScale = ContentScale.Crop
                )

            }
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                textShow(
                    text = "کد پرسنلی: ۵۰۰۰۹۹۰",
                )
                textShow(text = "نانا قالبی ")
                textShow(text = "کارشناس نرم افزار ")

                ExpandableUnderLineCard(
                    title = "اطلاعات کاربری",
                    painter = painterResource(Res.drawable.ic_profile),
                    textColor = Colors.text75
                ) {
                    InformationAccountScreen()
                }
            }


        }
    }
}


@Composable
fun textShow(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier.padding(horizontal = 8.dp, vertical = 3.dp),
        text = text,
        fontFamily = Vazir(),
        color = Colors.text75
    )
}