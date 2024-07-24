package com.zarholding.zar

import ui.requirement.App
import di.initKoin
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import util.windows_size.WindowSize


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                windowSize = rememberWindowSize(),
                windowWidth = rememberWindowWidth(),

            )
        }
    }
}


@Composable
private fun Activity.rememberWindowSize(): WindowSize {
    val configuration = LocalConfiguration.current
    val windowMetrics = remember(configuration.screenWidthDp) {
        configuration.screenWidthDp.dp
    }
    return WindowSize.basedOnWidth(windowMetrics)
}

@Composable
private fun Activity.rememberWindowWidth(): Dp {
    val configuration = LocalConfiguration.current
    val windowMetrics = remember(configuration.screenWidthDp) {
        configuration.screenWidthDp.dp
    }
    return windowMetrics
}