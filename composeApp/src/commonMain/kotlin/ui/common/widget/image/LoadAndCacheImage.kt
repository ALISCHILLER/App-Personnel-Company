package ui.common.widget.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.crossfade
import coil3.util.DebugLogger


@Composable
fun LoadAndCacheImage(
    modifier: Modifier,
    imageLink: String,
    token: String
) {
    AsyncImage(
        modifier = modifier,
        model = imageLink,
        contentScale = ContentScale.FillBounds,
        contentDescription = "",
        onError =  {
                   println("-------- onError = $it ----------------")
        },
        onLoading =  {
            println("-------- onLoading = $it ----------------")
        },
        onSuccess = {
            println("-------- onSuccess = $it ----------------")
        }
    )

/*    Image(
        modifier = modifier,
        painter = rememberAsyncImagePainter(
            model = ImageRequest
                .Builder(context = LocalPlatformContext.current)
                .data("https://axprint.com/blog/wp-content/uploads/2020/10/girl4.jpg")
                .crossfade(true)
                .build()
        ),
        contentDescription = "icon",
        contentScale = ContentScale.FillBounds
    )*/
//
//    AsyncImage(
//        modifier = modifier,
//        contentDescription = "icon",
//        contentScale = ContentScale.FillBounds,
//        model = "https://axprint.com/blog/wp-content/uploads/2020/10/girl4.jpg"
//    )

}

fun getAsyncImageLoader(context: PlatformContext)=
    ImageLoader.Builder(context).crossfade(true).logger(DebugLogger()).build()