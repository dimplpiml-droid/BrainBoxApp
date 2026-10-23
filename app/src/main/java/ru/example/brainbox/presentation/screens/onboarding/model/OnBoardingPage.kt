package ru.example.brainbox.presentation.screens.onboarding.model

import android.media.Image
import androidx.annotation.DrawableRes

data class onBoardingPage(
    @DrawableRes val image: Int,
    @DrawableRes val slider: Int,
    val titleText: String,
)