package ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import ui.common.component.expandable.ExpandableUnderLineCard
import ui.common.widget.switchC.CustomSwitch
import ui.theme.Colors
import ui.theme.Colors.Companion.barcolorlight2


@Composable
fun InformationAccountScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        ExpandableUnderLineCard(
            title = "مدل خودرو",
            painter = painterResource(Res.drawable.ic_car),
            textColor = Colors.text75
        ) {
            CarModelCard()
        }
        Spacer(modifier = modifier.height(3.dp))
        InformationAccountCard(
            title = "تم برنامه",
            painter = painterResource(Res.drawable.ic_moon),
            textColor = Colors.text75
        ) {
            CustomSwitch(
                height = 30.dp,
                width = 60.dp,
                modifier = Modifier.padding(vertical = 3.dp),
                circleButtonPadding = 4.dp,
                circleBackgroundOnResource = Res.drawable.ic_true_switch,
                circleBackgroundOffResource = Res.drawable.ic_true_switch,
                onBackgroundColor = Colors.barcolorlight3,
                offBackgroundColor = Colors.barcolorlight3,
                borderColor = Colors.barcolorlight2,
                stateOn = 1,
                stateOff = 0,
                initialValue = 0,
                onCheckedChanged = {}
            )
        }
        Spacer(modifier = modifier.height(3.dp))
        InformationAccountCard(
            title = "ورود از طریق اثر انگشت",
            painter = painterResource(Res.drawable.ic_fingercricle),
            textColor = Colors.text75
        ) {
            CustomSwitch(
                height = 30.dp,
                width = 60.dp,
                modifier = Modifier.padding(vertical = 3.dp),
                circleButtonPadding = 4.dp,
                circleBackgroundOnResource = Res.drawable.ic_true_switch,
                circleBackgroundOffResource = Res.drawable.ic_true_switch,
                onBackgroundColor = Colors.barcolorlight3,
                offBackgroundColor = Colors.barcolorlight3,
                borderColor = Colors.barcolorlight2,
                stateOn = 1,
                stateOff = 0,
                initialValue = 1,
                onCheckedChanged = {}
            )
        }
        InformationAccountCard(
            title = "خروج از حساب کاربری",
            painter = painterResource(Res.drawable.ic_exite),
            enabledline = false,
            textColor = Colors.text75
        ){

        }

    }


}