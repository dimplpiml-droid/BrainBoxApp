package ru.example.brainbox.presentation.navigatoin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.example.brainbox.presentation.screens.SplashScreen
import ru.example.brainbox.presentation.screens.WelcomeScreen
import ru.example.brainbox.presentation.screens.onboarding.OnBoardingScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object OnBoarding : Screen("onboarding_screen")
    object Welcome: Screen("welcome_screen")
    object SignIn : Screen("sign_in_screen")
    object SignUp : Screen("sign_up_screen")
}

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
                SplashScreen(onSplashEnded = {
                    navController.navigate(Screen.OnBoarding.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                })

        }
        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(onFinishOnBoarding = {
                navController.navigate(Screen.Welcome.route)
            })
        }
        composable (route = Screen.Welcome.route){
            WelcomeScreen(onSignInClick = {}, onSignUpClick = {})
        }
    }
}
