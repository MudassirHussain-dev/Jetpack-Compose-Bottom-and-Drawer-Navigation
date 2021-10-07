package dev.hmh.jetpackcomposenavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun SimpleComposable() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val blueBox = createRefFor("blueBox")
        val guideline = createGuidelineFromStart(0.5f)

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(greenBox.bottom)
            start.linkTo(parent.start, margin = 50.dp)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(blueBox) {
            top.linkTo(redBox.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        createVerticalChain(greenBox, redBox, blueBox)
    }

    ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("blueBox")
        )
    }
}