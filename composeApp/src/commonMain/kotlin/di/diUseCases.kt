package di

import domain.use_case.AppVersionUseCase
import domain.use_case.UserInfoUseCase
import domain.use_case.UserPermissionUseCase
import domain.use_case.UserTokenUseCase
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

internal val diUseCasesModule = module {
    single { AppVersionUseCase(get()) } withOptions {
        createdAtStart()
    }

    single { UserTokenUseCase(get(), get()) } withOptions {
        createdAtStart()
    }

    single { UserPermissionUseCase(get(), get()) } withOptions {
        createdAtStart()
    }

    single { UserInfoUseCase(get(), get()) } withOptions {
        createdAtStart()
    }
}