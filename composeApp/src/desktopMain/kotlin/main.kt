import di.initKoin
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ui.requirement.App
import util.windows_size.WindowSize

fun main() = application {
    initKoin()
    val windowState = rememberWindowState(size = DpSize(1024.dp, 768.dp))
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyZar",
        state = windowState,
        resizable = false
    ) {
        App(windowSize = WindowSize.basedOnWidth(windowState.size.width), windowWidth = windowState.size.width)
    }
}