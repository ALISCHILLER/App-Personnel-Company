package di

import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module
import ui.screen.home.HomeViewModel
import ui.screen.login.LoginViewModel
import ui.screen.splash.SplashViewModel

internal val diViewModelsModule = module {
    factory { SplashViewModel(get(), get(), get(), get()) } withOptions {
        createdAtStart()
    }

    factory { LoginViewModel(get(), get()) } withOptions {
        createdAtStart()
    }

    factory { HomeViewModel(get()) } withOptions {
        createdAtStart()
    }
}