package ru.example.brainbox.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ru.example.brainbox.uikit.ui.theme.BrainBoxTypography
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxBackButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxOutlineTextField

@Composable
fun ResetScreen(
    onReturnPage: () -> Unit,
    ) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 45.dp)) {
        BrainBoxBackButton(onClick = onReturnPage)

        Spacer(modifier = Modifier.padding(bottom = 73.dp))

        Text(text = "Rest Your \n" +
                "Password",
            modifier = Modifier.padding(start = 35.dp),
            style = BrainBoxTypography.headlineLarge
        )

        Spacer(modifier = Modifier.padding(bottom = 45.dp))


        var passwordSate1 by rememberSaveable { mutableStateOf("") }
        var isPasswordVisible1 by remember { mutableStateOf(false) }
        BrainBoxOutlineTextField(
            value = passwordSate1,
            onValueChange = { passwordSate1 = it },
            leadingIcon = { tintColor ->
                Icon(
                    painterResource(com.example.uikit.R.drawable.ic_lock),
                    contentDescription = "Lock",
                    tint = tintColor
                )
            },
            trailingIcon = {
                IconButton(onClick ={isPasswordVisible1 = !isPasswordVisible1} ) {
                    Icon(
                        painter =
                            painterResource(id = com.example.uikit.R.drawable.ic_eye_off),
                        contentDescription = "Passwords Icon",
                    )
                }
            },
            placeholder = "Password",
            visualTransformation = if (isPasswordVisible1){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            },
            modifier = Modifier.padding(start = 32.dp, end = 38.dp)
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))

        var passwordSate by rememberSaveable { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
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
                IconButton(onClick ={isPasswordVisible = !isPasswordVisible} ) {
                    Icon(
                        painter =
                            painterResource(id = com.example.uikit.R.drawable.ic_eye_off),
                        contentDescription = "Passwords Icon",
                    )
                }
            },
            placeholder = "Password",
            visualTransformation = if (isPasswordVisible){
                VisualTransformation.None
            }else{
                PasswordVisualTransformation()
            },
            modifier = Modifier.padding(start = 36.dp, end = 34.dp)
        )

        Spacer(modifier = Modifier.padding(bottom = 32.dp))

        BrainBoxButton(text = "Reset",
            onClick = { Log.d("Reset", "Button reset clicked")},
            modifier = Modifier.padding(horizontal = 35.dp))
    }
}
