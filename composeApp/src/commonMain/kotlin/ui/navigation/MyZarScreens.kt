package ui.navigation

enum class MyZarScreens {
    SplashScreen,
    LoginScreen,
    HomeScreen,
    SettingScreen,
    CarTableScreen;

    companion object{
        fun fromRoute(route: String?): MyZarScreens =
            when(route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                LoginScreen.name -> LoginScreen
                HomeScreen.name -> HomeScreen
                SettingScreen.name -> SettingScreen
                CarTableScreen.name -> CarTableScreen
                null -> SplashScreen
                else -> SplashScreen
            }
    }
}