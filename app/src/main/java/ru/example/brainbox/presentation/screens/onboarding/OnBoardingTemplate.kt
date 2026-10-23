package ru.example.brainbox.presentation.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.example.brainbox.R
import ru.example.brainbox.presentation.screens.onboarding.model.onBoardingPage
import ru.example.brainbox.uikit.ui.theme.PoppinsFontFamily
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxNavigaorCard
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxTextSkip

@Composable
fun OnBoardingTemplate(
    page: onBoardingPage,
    onSkipClick: () -> Unit,
    onPrevClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 45.dp, top = 41.dp, bottom = 23.dp),
            contentAlignment = Alignment.TopEnd
        ) {
            BrainBoxTextSkip(onClick = onSkipClick)
        }
        Image(
            painter = painterResource(page.image),
            contentDescription = "OnBoardingRobot",
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 10.dp,
                    top = 5.dp
                ),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.TopCenter
        )
        Image(
            painter = painterResource(page.slider),
            contentDescription = "slider",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 17.dp, top = 17.dp),
        )
        Text(
            text = page.titleText,
            fontFamily = PoppinsFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            color = Color(0xFF23262F),
            modifier = Modifier.padding(bottom = 5.dp)
        )
        Text(
            text = "Chat with the smartest AI Future\n" + "  Experience power of AI with us",
            fontWeight = FontWeight.Light,
            fontFamily = PoppinsFontFamily,
            fontSize = 16.sp,
            color = Color(0xFF8E9295),
            modifier = Modifier.padding(bottom = 30.dp)
        )
        BrainBoxNavigaorCard(onPrevClick = onPrevClick, onNextclick = onNextClick)
    }
}


//@Composable
//@Preview(showBackground = true)
//fun OnBoardingTemplateView() {
//    OnBoardingTemplate(
//        onSkipClick = {},
//        imagePainter = painterResource(R.drawable.robot1),
//        slider = painterResource(com.example.uikit.R.drawable.slider1),
//        titleText = "Unlock the Power\n" +
//                "       Of  Future AI"
//    )
//}