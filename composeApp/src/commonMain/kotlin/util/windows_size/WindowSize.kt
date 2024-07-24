package util.windows_size

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSize {
    COMPACT,
    MEDIUM,
    EXPANDED;

    companion object {
        fun basedOnWidth(windowWidth: Dp): WindowSize {
            return when {
                windowWidth < 840.dp -> COMPACT
                windowWidth < 841.dp -> MEDIUM
                else -> EXPANDED
            }
        }
        fun getSize(windowWidth: Dp):Dp{
            return windowWidth
        }

    }
}