package ui.navigation

import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo

class MyZarRoutManager {

    companion object {


        //------------------------------------------------------------------------------------------ gotoLoginScreen
        fun gotoLoginScreen(navigator: Navigator) {
            navigator.navigate(route = MyZarScreens.LoginScreen.name,
                options = NavOptions(launchSingleTop = true, popUpTo = PopUpTo(
                    route = MyZarScreens.LoginScreen.name
                ))
            )
        }
        //------------------------------------------------------------------------------------------ gotoLoginScreen



        //------------------------------------------------------------------------------------------ gotoHomeScreen
        fun gotoHomeScreen(navigator: Navigator) {
            navigator.navigate(route = MyZarScreens.HomeScreen.name,
                options = NavOptions(launchSingleTop = true, popUpTo = PopUpTo(
                    route = MyZarScreens.HomeScreen.name
                ))
            )
        }
        //------------------------------------------------------------------------------------------ gotoHomeScreen



        //------------------------------------------------------------------------------------------ gotoSettingScreen
        fun gotoSettingScreen(navigator: Navigator) {
            navigator.navigate(route = MyZarScreens.SettingScreen.name,
                options = NavOptions(launchSingleTop = true, popUpTo = PopUpTo(
                    route = MyZarScreens.SettingScreen.name
                ))
            )
        }
        //------------------------------------------------------------------------------------------ gotoSettingScreen



        //------------------------------------------------------------------------------------------ gotoCarTableScreen
        fun gotoCarTableScreen(navigator: Navigator) {
            navigator.navigate(route = MyZarScreens.CarTableScreen.name,
                options = NavOptions(launchSingleTop = true, popUpTo = PopUpTo(
                    route = MyZarScreens.CarTableScreen.name
                ))
            )
        }
        //------------------------------------------------------------------------------------------ gotoCarTableScreen


    }


}