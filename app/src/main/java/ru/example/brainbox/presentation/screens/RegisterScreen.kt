package ru.example.brainbox.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.brainbox.uikit.ui.theme.BrainBoxTypography
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxBackButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxOutlineTextField
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxSocialButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxTextLink
import ru.example.brainbox.uikit.ui.theme.components.SocialMedia

@Composable
fun RegisterScreen(
    onReturnPage: () -> Unit,
    onRegisterClick: () -> Unit,
    onAuthorizationPage: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .padding(top = 45.dp)
                .graphicsLayer(clip = false)
        ) {
            BrainBoxBackButton(onClick = onReturnPage)

            Spacer(modifier = Modifier.padding(bottom = 73.dp))

            Text(
                text = "Create your\n" +
                        "Account",
                style = BrainBoxTypography.headlineLarge
            )

            Spacer(modifier = Modifier.padding(bottom = 50.dp))

            var fullNameState by rememberSaveable { mutableStateOf("") }
            BrainBoxOutlineTextField(
                value = fullNameState,
                onValueChange = {
                    fullNameState = it
                },
                leadingIcon = { tintColor ->
                    Icon(
                        painterResource(
                            com.example.uikit.R.drawable.ic_user
                        ),
                        contentDescription = "User icon",
                        tint = tintColor
                    )
                },
                placeholder = "Full Name"
            )

            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            var emailState by rememberSaveable { mutableStateOf("") }
            BrainBoxOutlineTextField(
                value = emailState,
                onValueChange = { emailState = it },
                leadingIcon = { tintColor ->
                    Icon(
                        painterResource(com.example.uikit.R.drawable.ic_email),
                        contentDescription = "Email",
                        tint = tintColor
                    )
                },
                placeholder = "Enter Your Email"
            )

            Spacer(modifier = Modifier.padding(bottom = 20.dp))

            var passwordSate by rememberSaveable { mutableStateOf("") }
            BrainBoxOutlineTextField(
                value = passwordSate,
                onValueChange = { passwordSate = it },
                leadingIcon = { tintColor ->
                    Icon(
                        painterResource(com.example.uikit.R.drawable.ic_lock),
                        contentDescription = "Lock",
                        tint = tintColor
                    )
                },
                trailingIcon = {
                    Icon(
                        painterResource(com.example.uikit.R.drawable.ic_eye_off),
                        contentDescription = "Eye off"
                    )
                },
                placeholder = "Password",
                isPassword = true
            )

            Spacer(modifier = Modifier.padding(bottom = 25.dp))

            BrainBoxButton(
                text = "Register",
                onClick = onRegisterClick,
                modifier = Modifier,
            )

            Spacer(modifier = Modifier.padding(bottom = 14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Already Have An Account? ",
                    style = BrainBoxTypography.bodyLarge,
                    fontWeight = FontWeight.Normal
                )
                BrainBoxTextLink(
                    text = "Sign in",
                    onClick = onAuthorizationPage
                )
            }
            Spacer(modifier = Modifier.padding(bottom = 35.dp))

        }
        Icon(
            painterResource(com.example.uikit.R.drawable.horizontal_line),
            contentDescription = "Horizontal line",
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp)
        ) {
            Spacer(modifier = Modifier.padding(bottom = 22.dp))

            Text(
                text = "Continue With Accounts",
                style = BrainBoxTypography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
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
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    RegisterScreen(
        onRegisterClick = {}, onReturnPage = {},
        onAuthorizationPage = {})
}
