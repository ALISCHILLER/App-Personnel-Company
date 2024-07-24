package ui.common.widget.exposedDropMenuC


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.common.widget.textfield.CustomBasicTextField
import ui.theme.Colors.Companion.White
import ui.theme.Colors.Companion.barcolorlight2



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> ExposedDropdownMenuSample(
    listOptions: List<T>,
    modifier: Modifier = Modifier,
    initiallySelectedOption: T? = null,
    onOptionSelected: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(initiallySelectedOption ?: listOptions.first()) }


    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        },
        modifier = modifier
    ) {
        CustomBasicTextField(
            value =  selectedOption.toString(),
            onValueChange = {  },
            borderColor = barcolorlight2,
            backgroundColor = barcolorlight2,
            corner = RoundedCornerShape(9.dp),
            textColor = Color.White,
            leadingIcon = Icons.Filled.ArrowDropDown,
            modifier = Modifier.menuAnchor(),
            enabled = false,
            leadingColor = White
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            listOptions.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item.toString()) },
                    onClick = {
                        selectedOption = item
                        expanded = false
                        onOptionSelected(item)
                    }
                )
            }
        }
    }

}


//@Composable
//fun ExposedDropdownMenuSamplePreview() {
//    MaterialTheme {
//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            ExposedDropdownMenuSample(
//                modifier = Modifier
//                    .padding(10.dp)
//                    .width(90.dp)
//                    .height(50.dp)
//                    .background(Color.Yellow)
//                ,
//                listOptions = listOf("الف", "Cappuccino", "Espresso", "Latte", "Mocha"),
//                onOptionSelected = { selectedOption ->
//                    // Handle option selected
//                }
//            )
//        }
//    }
//}
