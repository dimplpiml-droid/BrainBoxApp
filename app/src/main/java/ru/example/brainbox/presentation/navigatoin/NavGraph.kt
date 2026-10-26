package ru.example.brainbox.presentation.navigatoin

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.example.brainbox.presentation.screens.ForgetPasswordScreen
import ru.example.brainbox.presentation.screens.LoginScreen
import ru.example.brainbox.presentation.screens.PhoneNumberScreen
import ru.example.brainbox.presentation.screens.RegisterScreen
import ru.example.brainbox.presentation.screens.ResetScreen
import ru.example.brainbox.presentation.screens.SplashScreen
import ru.example.brainbox.presentation.screens.WelcomeScreen
import ru.example.brainbox.presentation.screens.onboarding.OnBoardingScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object OnBoarding : Screen("onboarding_screen")
    object Welcome : Screen("welcome_screen")
    object SignIn : Screen("sign_in_screen")
    object SignUp : Screen("sign_up_screen")
    object PhoneNumber : Screen("phone_number_screen")
    object ForgetPassword : Screen("forget_password_screen")
    object ResetScreen : Screen("reset_screen")
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
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                onSignInClick = { navController.navigate(Screen.SignIn.route) },
                onSignUpClick = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }
        composable(route = Screen.SignUp.route) {
            RegisterScreen(
                onReturnPage = { navController.popBackStack() },
                onRegisterClick = { navController.navigate(Screen.PhoneNumber.route) },
                onAuthorizationPage = {
                    navController.navigate(Screen.SignIn.route)
                })
        }
        composable(route = Screen.PhoneNumber.route) {
            PhoneNumberScreen(
                onReturnPage = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Screen.SignIn.route) {
            LoginScreen(
                onReturnPage = {
                    navController.popBackStack()
                },
                onForgetPassword = {
                    navController.navigate(Screen.ForgetPassword.route)
                },
                onRegistrationScreen = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }
        composable(route = Screen.ForgetPassword.route) {
            ForgetPasswordScreen(onReturnPage = {
                navController.popBackStack()
            }, onResetScreen = {
navController.navigate(Screen.ResetScreen.route)
            })
        }
        composable(route = Screen.ResetScreen.route) {
            ResetScreen (
                onReturnPage = {
                    navController.popBackStack()
                },
            )
        }
    }
}
