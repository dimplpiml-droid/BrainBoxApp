package ru.example.brainbox.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.example.brainbox.R
import ru.example.brainbox.uikit.ui.theme.BrainBoxTypography
import ru.example.brainbox.uikit.ui.theme.SecondaryButtonText
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxBackButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxButton
import ru.example.brainbox.uikit.ui.theme.components.BrainBoxOutlineTextField

@Composable
fun PhoneNumberScreen(
    onReturnPage: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 35.dp, end = 35.dp, top = 45.dp)
    ) {
        BrainBoxBackButton(onClick = onReturnPage)

        Spacer(modifier = Modifier.padding(bottom = 74.dp))

        Text(
            text = "Enter Your Phone\nNumber",
            style = BrainBoxTypography.headlineLarge,
        )

        Spacer(modifier = Modifier.padding(bottom = 50.dp))

        var phoneState by remember { mutableStateOf("") }
        BrainBoxOutlineTextField(
            value = phoneState,
            onValueChange = { phoneState = it },
            leadingIcon = { tintColor ->
                Icon(
                    painterResource(com.example.uikit.R.drawable.ic_phone),
                    contentDescription = "Phone Number",
                    tint = tintColor
                )
            },
            placeholder = "Phone Number",
        )

        Spacer(modifier = Modifier.padding(bottom = 30.dp))

        BrainBoxButton(
            text = "Verification",
            onClick = {Log.d("Verification", "Кнопка Verification прожата")},
            modifier = Modifier,
        )

        Spacer(modifier = Modifier.padding(13.dp))

        BrainBoxButton(text = "Later",
            onClick = { Log.d("Later", "Later clicked") },
            modifier = Modifier,
            isEnable = false,
            color = SecondaryButtonText
        )
    }

}

@Composable
@Preview(showBackground = true)
fun PhoneNumberScreenPreview() {
    PhoneNumberScreen(onReturnPage = {},)
}

