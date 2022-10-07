//package com.app.pokedex.app.ui.utils
//
//import androidx.compose.animation.core.LinearEasing
//import androidx.compose.animation.core.Transition
//import androidx.compose.animation.core.repeatable
//import androidx.compose.animation.core.tween
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.geometry.Offset.Companion.Infinite
//
//
//private val rotation = FloatPropKey()
//
//private fun createDefinition(duration: Int) = transitionDefinition {
//    state(0) { this[rotation] = 0f }
//    state(1) { this[rotation] = 360f }
//
//    transition {
//        rotation using repeatable {
//            animation = tween {
//                easing = LinearEasing
//                this.duration = duration
//            }
//            iterations = Infinite
//        }
//    }
//}
//
//@Composable
//fun RotateIndefinitely(durationPerRotation: Int, children: @Composable() () -> Unit) {
//    Transition(definition = createDefinition(durationPerRotation), initState = 0, toState = 1) {
//        Rotate(it[rotation], children)
//    }
//}
//
//@Composable
//fun Rotate(degree: Float, children: @Composable() () -> Unit) {
//    Draw(children = children) { canvas, parent ->
//        val halfWidth = parent.width.value / 2
//        val halfHeight = parent.height.value / 2
//
//        canvas.save()
//        canvas.translate(halfWidth, halfHeight)
//        canvas.rotate(degree)
//        canvas.translate(-halfWidth, -halfHeight)
//        drawChildren()
//        canvas.restore()
//    }
//}