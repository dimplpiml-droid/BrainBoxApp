package ru.example.brainbox.presentation.screens.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import ru.example.brainbox.R
import ru.example.brainbox.presentation.screens.onboarding.model.onBoardingPage



@Composable
fun OnBoardingScreen(
    onFinishOnBoarding: () -> Unit
) {
    var currentStep by remember { mutableStateOf(0) }

    val pages = listOf(
        onBoardingPage(
            image = R.drawable.robot1,
            slider = com.example.uikit.R.drawable.slider1,
            titleText = "Unlock the Power\n" + "       Of  Future AI"
        ),
        onBoardingPage(
            image = R.drawable.robot2,
            slider = com.example.uikit.R.drawable.slider2,
            titleText = "Chat With Your\n" +
                    "       Favourite Ai"
        ),
        onBoardingPage(
            image = R.drawable.robot3,
            slider = com.example.uikit.R.drawable.slider3,
            titleText = "Boost Your Mind\n" +
                    "   Power with Ai"
        )
    )

    val page = pages[currentStep]
    BackHandler(enabled = currentStep > 0) {
        currentStep--
    }

    OnBoardingTemplate(
        page = page,
        onSkipClick = onFinishOnBoarding,
        onPrevClick = {
            if (currentStep > 0) {
                currentStep--
            }
        },
        onNextClick = {
            if (currentStep < pages.size - 1) {
                currentStep++
            } else {
                onFinishOnBoarding()
            }
        }
    )
}
