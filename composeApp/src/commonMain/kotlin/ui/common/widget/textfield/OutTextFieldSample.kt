package ui.common.widget.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Colors.Companion.barcolorlight2
import ui.theme.Colors.Companion.White

@Composable
fun OutTextFieldSample(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    icon: ImageVector? = null,
    isPassword: Boolean = false,
    corner: RoundedCornerShape = RoundedCornerShape(26.dp),
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLength: Int = 1000,
    textSize: Int = 12,
    textAlign: TextAlign = TextAlign.Center,
    fontStyle: FontStyle = FontStyle.Normal
) {
    Box(
        modifier = modifier
            .padding(0.dp) // Adjust the outer padding as needed
            .background(barcolorlight2, shape = corner) // Background with corner shape
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { newValue ->
                if (newValue.length <= maxLength) {
                    onValueChange(newValue)
                }
            },
            singleLine = true,
            shape = corner,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = barcolorlight2,
                focusedContainerColor = barcolorlight2,
                focusedTextColor = White,
                unfocusedTextColor = White
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = keyboardType
            ),
            textStyle = TextStyle(
                fontSize = textSize.sp,
                textAlign = textAlign,
                fontStyle = fontStyle
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp) // Adjust internal padding
        )
    }
}
