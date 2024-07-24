package ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_iranflag
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.common.widget.button.CustomButton
import ui.common.widget.exposedDropMenuC.ExposedDropdownMenuSample
import ui.common.widget.textfield.CustomBasicTextField
import ui.common.widget.textfield.OutTextFieldSample
import ui.common.widget.textfield.RoundedIconTextField
import ui.theme.Colors
import ui.theme.Colors.Companion.OrangeStatus
import ui.theme.Colors.Companion.barcolorlight
import ui.theme.Colors.Companion.barcolorlight2
import ui.theme.Colors.Companion.tagcar
import ui.theme.Colors.Companion.White

@Composable
fun CarModelCard(modifier: Modifier = Modifier) {
    var nameCar by remember { mutableStateOf("") }
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            TagCar()

            RoundedIconTextField(
                value = nameCar,
                onValueChange = { nameCar = it },
                label = "نام خودرو",
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                corner = RoundedCornerShape(9.dp),
                labelColor =Colors.primary100,
            )
            CustomButton(
                text = "ثبت",
                onClick = {},
                btnColor =  Colors.primary100,
                textColor = White,
                fontSize = 10,
                fontWeight = FontWeight.Bold,
                shape = RoundedCornerShape(10.dp),
                modifier = modifier.fillMaxWidth()
            )

        }
    }
}


@Composable
fun TagCar(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf("") }
    val itemHeight = 60.dp // ارتفاع یکسان برای همه اجزا

    Row(
        modifier = modifier
            .padding(top = 3.dp)
            .fillMaxWidth()
            .border(1.dp, color = Color.Black, shape = RoundedCornerShape(9.dp))
            .height(itemHeight),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.7f)
                .background(barcolorlight)
                .padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ایران",
            )

            CustomBasicTextField(
                value = number,
                onValueChange = { number = it },
                borderColor = barcolorlight2,
                backgroundColor = barcolorlight2,
                corner = RoundedCornerShape(12.dp),
                textColor = Color.White,
                keyboardType = KeyboardType.Number,
                maxLength = 2,
            )
        }

        Spacer(modifier = Modifier
            .background(Color.Black)
            .width(2.dp)
            .height(itemHeight)
        )

        Row(
            modifier = Modifier
                .weight(2.4f)
                .height(itemHeight)
                .background(barcolorlight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomBasicTextField(
                value = number,
                onValueChange = { number = it },
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .weight(1.5f)
                    .height(50.dp),
                borderColor = barcolorlight2,
                backgroundColor = barcolorlight2,
                corner = RoundedCornerShape(12.dp),
                textColor = Color.White,
                keyboardType = KeyboardType.Number,
                maxLength = 3,
            )

            ExposedDropdownMenuSample(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .height(50.dp)
                    .weight(2.3f),
                listOptions = listOf("الف", "ب", "پ", "ت", "ث"),
                onOptionSelected = { selectedOption ->
                    // Handle option selected
                }
            )

            CustomBasicTextField(
                value = number,
                onValueChange = { number = it },
                modifier = Modifier
                    .padding(horizontal = 3.dp)
                    .weight(1.3f)
                    .height(50.dp),
                borderColor = barcolorlight2,
                backgroundColor = barcolorlight2,
                corner = RoundedCornerShape(12.dp),
                textColor = Color.White,
                keyboardType = KeyboardType.Number,
                maxLength = 2,
            )
        }

        Card(
            modifier = Modifier
                .weight(0.5f)
                .height(itemHeight)
                .background(
                    tagcar, shape = RoundedCornerShape(
                        topEnd = 10.dp,
                        bottomEnd = 10.dp,
                    )
                ),
            colors = CardDefaults.cardColors(
                containerColor = tagcar
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_iranflag),
                    contentDescription = "iranflag"
                )
                Text(
                    text = "I.R.",
                    color = White,
                )
                Text(
                    text = "IRAN",
                    color = White,
                    fontSize = 9.sp
                )
            }
        }
    }
}

@Preview()
@Composable
private fun CarModelCardPreview() {

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
    ) {
        CarModelCard()
    }

}
