package com.example.caffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Urbanist

@Composable
fun CaffeineButton(
    onClick: () -> Unit,
    text: String,
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        contentPadding = PaddingValues(
            horizontal = 32.dp,
            vertical = 16.dp
        ),
        modifier = Modifier
            .height(56.dp)
            .padding(horizontal = 32.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(end = 8.dp),
            style = TextStyle(
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xDEFFFFFF),
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .wrapContentWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    CaffeineButton(
        onClick = {},
        text = "bring my coffee",
        painter = painterResource(id = R.drawable.cup)

    )
}