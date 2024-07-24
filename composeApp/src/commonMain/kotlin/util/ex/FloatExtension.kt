package util.ex

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity

//-------------------------------------------------------------------------------------------------- toDp
@Composable
fun Float.toDp() = LocalDensity.current.run { toDp() }
//-------------------------------------------------------------------------------------------------- toDp
