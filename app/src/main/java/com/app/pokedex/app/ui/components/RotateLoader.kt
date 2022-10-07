package com.app.pokedex.app.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.app.pokedex.R

@Composable
fun RotateLoader() {
    val animation = rememberInfiniteTransition()
    val angle = animation.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )
    Image(
        painter = painterResource(id = R.drawable.pokeball),
        contentDescription = null,
        modifier = Modifier.rotate(angle.value),
        colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
    )
}