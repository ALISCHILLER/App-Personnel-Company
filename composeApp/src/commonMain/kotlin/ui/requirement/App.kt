package ui.requirement
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.Dp
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import ui.common.widget.image.getAsyncImageLoader
import ui.navigation.MyZarNavigation
import util.windows_size.WindowSize

//-------------------------------------------------------------------------------------------------- App
@OptIn(ExperimentalCoilApi::class)
@Composable
fun App(
    windowSize: WindowSize,
    windowWidth: Dp,

    ) {
    MaterialTheme {

        setSingletonImageLoaderFactory { context ->
            getAsyncImageLoader(context)
        }

        MyZarNavigation(
            windowSize = windowSize,
            windowWidth = windowWidth
        )
    }
}
//-------------------------------------------------------------------------------------------------- App