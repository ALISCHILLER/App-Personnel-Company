package ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.splash_mobile_1
import org.jetbrains.compose.resources.painterResource
import ui.common.component.LoginInputComponent
import ui.theme.PaddingExtraLarge

//-------------------------------------------------------------------------------------------------- LoginCompactScreen
@Composable
internal fun LoginCompactScreen(
    userNameValue: String,
    userNameIsError: Boolean,
    passwordValue: String,
    loading: Boolean,
    passwordIsError: Boolean,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val painter = painterResource(Res.drawable.splash_mobile_1)
        Box(modifier = Modifier
            .fillMaxSize()
            .drawBehind {
                with(painter) {
                    draw(size)
                }
            }
            .drawWithContent {
                with(drawContext.canvas.nativeCanvas) {
                    val checkPoint = saveLayer(null, null)
                    drawContent()
                    val path = Path().apply {
                        moveTo(x = 0f, y = 0f)
                        lineTo(x = size.width, y = 0f)
                        lineTo(x = size.width, y = size.height * 0.6f)
                        cubicTo(
                            x1 = size.width,
                            y1 = size.height * 0.6f,
                            x2 = size.width * 0.5f,
                            y2 = size.height * 0.45f,
                            x3 = 0f,
                            y3 = size.height * 0.6f
                        )
                        lineTo(x = 0f, y = 0f)
                        close()
                    }
                    drawPath(
                        path = path,
                        color = Color.Transparent,
                        blendMode = BlendMode.Clear
                    )

                    restoreToCount(checkPoint)
                }
            }
            .blur(20.dp)
            .drawBehind {
                with(painter) {
                    draw(size)
                }
            }
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginInputComponent(
                modifier = Modifier
                    .padding(PaddingExtraLarge)
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                userNameValue = userNameValue,
                userNameIsError = userNameIsError,
                passwordValue = passwordValue,
                passwordIsError = passwordIsError,
                onUserNameChange = onUserNameChange,
                onPasswordChange = onPasswordChange,
                loading = loading,
                onLoginClick = onLoginClick
            )
        }
    }
}
//-------------------------------------------------------------------------------------------------- LoginCompactScreen

