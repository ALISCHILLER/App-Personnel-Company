package di

import data.service.AppVersionService
import data.service.LoginService
import data.service.PermissionService
import data.service.UserInfoService
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

internal val diServicesModule = module {
    factory { AppVersionService() } withOptions {
        createdAtStart()
    }

    factory { LoginService() } withOptions {
        createdAtStart()
    }

    factory { PermissionService() } withOptions {
        createdAtStart()
    }

    factory { UserInfoService() } withOptions {
        createdAtStart()
    }
}