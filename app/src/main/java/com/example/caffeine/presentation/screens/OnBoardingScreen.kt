package com.example.caffeine.presentation.screens

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.example.caffeine.R
import com.example.caffeine.presentation.components.CaffeineButton
import com.example.caffeine.presentation.components.HomeTopAppBar
import com.example.caffeine.ui.theme.Sniglet

@Composable
fun OnboardingScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            HomeTopAppBar()
            OnboardingText(modifier = Modifier.padding(top = 24.dp, bottom = 33.dp))
            GhostWithShadow()
        }
        CaffeineButton(
            onClick = {},
            text = "bring my coffee",
            painter = painterResource(id = R.drawable.cup),
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 32.dp)
        )
    }
}


@Composable
fun OnboardingText(
    modifier: Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        val infiniteTransition = rememberInfiniteTransition()

        val alpha by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 600,
                    easing = LinearEasing
                ),
                repeatMode = RepeatMode.Reverse

            )

        )
        Text(
            text = "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus",
            modifier = Modifier,
            style = TextStyle(
                fontFamily = Sniglet,
                fontSize = 32.sp,
                color = Color(0xFF1F1F1F),
                lineHeight = 50.sp,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
        Image(
            painter = painterResource(id = R.drawable.astrisk),
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha)
                .align(Alignment.TopEnd)
        )
        Image(
            painter = painterResource(id = R.drawable.astrisk),
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha)
                .align(BiasAlignment(-0.9f, -0.3f))
        )
        Image(
            painter = painterResource(id = R.drawable.astrisk),
            contentDescription = null,
            modifier = Modifier
                .alpha(alpha)
                .align(BiasAlignment(1.2f, 1.1f))
        )
    }
}

@Composable
fun GhostWithShadow() {

    val infiniteTransition = rememberInfiniteTransition()

    val ghostOffset by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = (-20).dp,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 2000, easing = CubicBezierEasing(0.33f, 0f, 0.67f, 1f)
            ),
            repeatMode = RepeatMode.Reverse
        ),
        typeConverter = Dp.VectorConverter
    )

    val progress = remember(ghostOffset) {
        (ghostOffset.value / -20f).coerceIn(0f, 1f)
    }

    val shadowAlpha = lerp(1f, 0.3f, progress)

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ghost),
            contentDescription = null,
            modifier = Modifier
                .size(244.dp)
                .offset(y = ghostOffset)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Canvas(
            modifier = Modifier
                .size(width = 178.dp, height = 28.dp)
                .graphicsLayer {
                    alpha = shadowAlpha
                    renderEffect = BlurEffect(20f, 20f, TileMode.Decal)
                    translationY = -ghostOffset.toPx() + 140.dp.toPx()
                }

        ) {
            drawOval(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Black.copy(alpha = 0.25f), Color.Transparent),
                    radius = size.width
                ),
                size = size
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Preview() {
    OnboardingScreen()
}