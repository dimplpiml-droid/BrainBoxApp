package ru.example.brainbox.presentation.screens.onboarding.model

import androidx.annotation.DrawableRes

data class onBoardingPage(
    @DrawableRes val image: Int,
    @DrawableRes val slider: Int,
    val titleText: String,
)