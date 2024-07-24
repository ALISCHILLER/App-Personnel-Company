package ui.common.component.slider

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ui.common.widget.image.LoadAndCacheImage
import ui.theme.CornerSizeLarge
import ui.theme.PaddingNormal
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalSlider(
    modifier: Modifier
) {
    val scope = rememberCoroutineScope()
    val colors = listOf(
        "https://axprint.com/blog/wp-content/uploads/2020/10/girl4.jpg",
        "https://www.gfxdownload.ir/uploads/posts/2023-09/nature3.jpg",
        "https://dl1.mrtarh.com/QLUU-GXDA/preview.jpg",
        "https://www.jowhareh.com/images/Jowhareh/galleries_5/poster_24691af5-5db6-49c2-a775-6ce55ab66bc3.jpeg",
        "https://mag.parsnews.com/wp-content/uploads/2022/06/Most-Beautiful-Nature-Wallpapers-Top-Free-Most-Beautiful-25.jpg",
        "https://www.eligasht.com/Blog/wp-content/uploads/2019/03/maxresdefault-2.jpg"
    )
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { colors.size })
    LaunchedEffect(Unit) {
        scope.launch {
            while (true) {
                delay(3000)
                if (pagerState.currentPage + 1 == pagerState.pageCount)
                    pagerState.animateScrollToPage(
                        page = 0,
                        animationSpec = tween(durationMillis = 1500)
                    )
                else
                    pagerState.animateScrollToPage(
                        page = pagerState.currentPage + 1,
                        animationSpec = tween(durationMillis = 1500)
                    )
            }
        }
    }
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        contentPadding = PaddingValues(start = 55.dp, end = 55.dp, bottom = PaddingNormal, top = PaddingNormal),
        pageSpacing = 10.dp
    ) { page ->
        val pageOffset =
            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        val scaleFactor = 0.7f + (1f - 0.7f) * (1f - pageOffset.absoluteValue)
        val alphaFactor = 0.55f + (1f - 0.55f) * (1f - pageOffset.absoluteValue)

        LoadAndCacheImage(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    scaleY = scaleFactor
                }
                .alpha(
                    alphaFactor.coerceIn(0f, 1f)
                )
                .clip(RoundedCornerShape(CornerSizeLarge)),
            imageLink = colors[page],
            token = ""
        )
    }
}