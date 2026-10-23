package ru.example.brainbox.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.brainbox.uikit.ui.theme.BrainBoxTypography
import ru.example.brainbox.uikit.ui.theme.SecondaryButtonText
import ru.example.brainbox.uikit.ui.theme.UrbanistButtonTextStyle
import ru.example.brainbox.uikit.ui.theme.WelcomeTitleStyle
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxSocialButton
import ru.example.brainbox.uikit.ui.theme.components.ButtonKind
import ru.example.brainbox.uikit.ui.theme.components.ButtonShape
import ru.example.brainbox.uikit.ui.theme.components.SocialMedia

@Composable
fun WelcomeScreen(onSignInClick: () -> Unit, onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 137.dp, start = 25.dp, end = 25.dp, bottom = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Image(
            painter = painterResource(com.example.uikit.R.drawable.logo_mini),
            contentDescription = "logo"
        )

        Spacer(modifier = Modifier.padding(bottom = 50.dp))

        Text(
            text = "Welcome to\n" +
                    "  BrainBox",
            style = WelcomeTitleStyle
        )

        Spacer(modifier = Modifier.padding(bottom = 83.dp))

        BrainBoxButton(
            text = "Log in",
            onSignInClick,
            modifier = Modifier,
            shape = ButtonShape.Pill,
            style = UrbanistButtonTextStyle
        )

        Spacer(modifier = Modifier.padding(bottom = 22.dp))

        BrainBoxButton(
            text = "Sign up",
            onClick = onSignUpClick,
            modifier = Modifier,
            kind = ButtonKind.Secondary,
            shape = ButtonShape.Pill,
            style = UrbanistButtonTextStyle,
            color = SecondaryButtonText
        )

        Spacer(modifier = Modifier.padding(bottom = 44.dp))

        Text(
            text = "Continue With Accounts",
            style = BrainBoxTypography.bodyLarge
        )

        Spacer(modifier = Modifier.padding(bottom = 23.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            BrainBoxSocialButton(
                text = "GOOGLE",
                onClick = { },
                modifier = Modifier.weight(1f),
                socialMedia = SocialMedia.Google
            )


            BrainBoxSocialButton(
                text = "FACEBOOK",
                onClick = { },
                modifier = Modifier.weight(1f),
                socialMedia = SocialMedia.Facebook
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun WelcomeScreenPreview() {
    WelcomeScreen(onSignUpClick = {}, onSignInClick = {})
}
