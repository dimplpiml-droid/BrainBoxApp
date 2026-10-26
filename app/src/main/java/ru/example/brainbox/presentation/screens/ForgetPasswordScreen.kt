package ru.example.brainbox.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import ru.example.brainbox.uikit.ui.theme.BrainBoxTypography
import ru.example.brainbox.uikit.ui.theme.MutedText
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxBackButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxButton
import ru.example.brainbox.uikit.ui.theme.components.CardForgetPassword

@Composable
fun ForgetPasswordScreen(
    onReturnPage: () -> Unit,
    onResetScreen: () -> Unit
    ){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 45.dp, start = 35.dp, end = 35.dp)) {
        BrainBoxBackButton(onClick = onReturnPage)

        Spacer(modifier = Modifier.padding(bottom = 74.dp))

        Text(text = "Forget Password",
            style = BrainBoxTypography.headlineLarge
        )

        Spacer(modifier = Modifier.padding(bottom = 8.dp))

        Text(text = "Select which contact details should we use to reset your password",
            style = BrainBoxTypography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = MutedText,
        )

        Spacer(modifier = Modifier.padding(bottom = 43.dp))

        var selectedMethod by remember { mutableStateOf("") }

        CardForgetPassword(image = painterResource(R.drawable.ic_black_email),
            mainText = "Email",
            secondaryText = "Code Send to your email",
            isSelected = selectedMethod == "email",
            onClick = {selectedMethod = "email"}
            )

Spacer(modifier = Modifier.padding(bottom = 25.dp))

        CardForgetPassword(image = painterResource(R.drawable.ic_black_phone),
            mainText = "Phone",
            secondaryText = "Code Send to your email",
            isSelected = selectedMethod == "phone",
            onClick = {selectedMethod = "phone"}
        )

        Spacer(modifier = Modifier.padding(bottom = 44.dp))

        BrainBoxButton(text = "Next",
            onClick = onResetScreen,
            modifier = Modifier)
    }
}

@Composable
@Preview(showBackground = true)
fun ForgetPasswordScreenPreview(){
    ForgetPasswordScreen(onReturnPage = {}, onResetScreen = {})
}