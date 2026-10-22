package ru.example.brainbox.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.example.brainbox.uikit.ui.theme.BrainBoxTheme
import ru.example.brainbox.uikit.ui.theme.PoppinsFontFamily
import ru.example.brainbox.uikit.ui.theme.PrimaryText

@Composable
fun SplashScreen(
    onSplashEnded: () -> Unit
){
    LaunchedEffect(key1 = true){
        delay(2000L)
        onSplashEnded()
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Icon(painter = painterResource(com.example.uikit.R.drawable.logo_big),
            contentDescription = "Main logo",
            modifier = Modifier.size(142.dp))
    }

    Column(modifier = Modifier.fillMaxSize().padding(bottom = 39.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        Text(text = "BrainBox",
            fontFamily = PoppinsFontFamily,
            color = Color(0xFF000000),
            fontSize = 35.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
Text(text = "Version 1.0",
    fontFamily = PoppinsFontFamily,
    color = Color(0xFF757171),
    fontSize = 14.sp,
    fontWeight = FontWeight.Light)
    }
}