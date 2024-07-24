package ui.common.widget.snackbar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ui.theme.Colors
import ui.theme.CornerSizeNormal

//-------------------------------------------------------------------------------------------------- MyZarSnackBar
@Composable
fun MyZarSnackBar(
    snackBarHostState: SnackbarHostState,
    containerColor: Color
){
    SnackbarHost(hostState = snackBarHostState) {
        Snackbar(
            snackbarData = it,
            containerColor = containerColor,
            actionColor = Colors.Dark100,
            contentColor = Colors.Dark100,
            dismissActionContentColor = Colors.Dark100,
            shape = RoundedCornerShape(CornerSizeNormal)
        )
    }
}
//-------------------------------------------------------------------------------------------------- MyZarSnackBar


//-------------------------------------------------------------------------------------------------- showMessage
fun showMessage(
    coroutineScope: CoroutineScope,
    snackBarHostState: SnackbarHostState,
    message: String
) {
    coroutineScope.launch {
        snackBarHostState.showSnackbar(
            message = message,
            withDismissAction = true,
            duration = SnackbarDuration.Short
        )
    }
}
//-------------------------------------------------------------------------------------------------- showMessage