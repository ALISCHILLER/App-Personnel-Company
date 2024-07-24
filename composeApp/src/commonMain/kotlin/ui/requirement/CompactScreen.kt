package ui.requirement

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.navigation.BackHandler
import moe.tlaster.precompose.navigation.Navigator
import ui.common.component.customdrawer.CustomDrawer
import ui.common.component.customdrawer.CustomDrawerState
import ui.common.component.customdrawer.isOpened
import ui.common.component.menu.compact.MenuCompact
import ui.common.component.topBarMenu.TopBarComponent
import ui.common.widget.snackbar.MyZarSnackBar
import ui.navigation.GetNavHost
import ui.screen.profile.ProfileScreen
import ui.theme.Colors
import util.windows_size.WindowSize
import kotlin.math.roundToInt


//-------------------------------------------------------------------------------------------------- CompactScreen
@Composable
fun CompactScreen(
    navigator: Navigator,
    windowSize: WindowSize,
    startDestination: String,
    mySnackBarHostState: SnackbarHostState,
    snackBarContainerColor: MutableState<Color>,
    isShowMenu: MutableState<Boolean>,
    backgroundColor: Color,
    windowWidth: Dp,
) {
    var drawerState by remember { mutableStateOf(CustomDrawerState.Closed) }

    val density = LocalDensity.current.density

    val screenWidth = remember {
        derivedStateOf { (windowWidth * density).value.roundToInt() }
    }
    val offsetValue by remember { derivedStateOf { ((screenWidth.value / 4.2) + 5).dp } }

    val animatedOffset by animateDpAsState(
        targetValue = if (drawerState.isOpened()) offsetValue else 0.dp,
        label = "Animated Offset"
    )
    val animatedScale by animateFloatAsState(
        targetValue = if (drawerState.isOpened()) 0.9f else 1f,
        label = "Animated Scale"
    )

    BackHandler(enabled = drawerState.isOpened()) {
        drawerState = CustomDrawerState.Closed
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (isShowMenu.value)
                MenuCompact(
                    modifier = Modifier.fillMaxWidth(),
                    height = 100.dp,
                    navigator = navigator,
                    backgroundColor = backgroundColor
                )
        },
        snackbarHost = {
            MyZarSnackBar(
                snackBarHostState = mySnackBarHostState,
                containerColor = snackBarContainerColor.value
            )
        },

        topBar = {
            TopBarComponent(
                modifier = Modifier
                    .background(backgroundColor),
                drawerState = drawerState,
                onDrawerClick = { drawerState = it },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .background(backgroundColor),

            ) {
            if (drawerState.isOpened())
                CustomDrawer(
                    modifier = Modifier.width(offsetValue),
                    onCloseClick = { drawerState = CustomDrawerState.Closed }
                ) {
                    ProfileScreen()
                }

            GetNavHost(
                windowSize = windowSize,
                navigator = navigator,
                startDestination = startDestination,
                mySnackBarHostState = mySnackBarHostState,
                snackBarContainerColor = snackBarContainerColor,
                isShowMenu = isShowMenu,
                modifier = Modifier
                    .offset(x = animatedOffset)
                    .scale(scale = animatedScale)
//                    .shadow(shape = RoundedCornerShape(3.dp), elevation = 3.dp),
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- CompactScreen