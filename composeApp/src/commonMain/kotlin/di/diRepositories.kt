package di

import domain.repository.AppVersionRepository
import data.repository.AppVersionRepositoryImpl
import data.repository.permission.LocalPermissionRepositoryImpl
import data.repository.permission.RemotePermissionRepositoryImpl
import data.repository.token.LocalTokenRepositoryImpl
import data.repository.token.RemoteTokenRepositoryImpl
import data.repository.userinfo.LocalUserInfoRepositoryImpl
import data.repository.userinfo.RemoteUserInfoRepositoryImpl
import domain.repository.permission.LocalPermissionRepository
import domain.repository.permission.RemotePermissionRepository
import domain.repository.token.LocalTokenRepository
import domain.repository.token.RemoteTokenRepository
import domain.repository.userinfo.LocalUserInfoRepository
import domain.repository.userinfo.RemoteUserInfoRepository
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

internal val diRepositoriesModule = module {
    single<AppVersionRepository> { AppVersionRepositoryImpl(get(), get()) } withOptions {
        createdAtStart()
    }
    single<LocalTokenRepository> { LocalTokenRepositoryImpl(get()) } withOptions {
        createdAtStart()
    }

    single<RemoteTokenRepository> { RemoteTokenRepositoryImpl(get(), get(), get()) } withOptions {
        createdAtStart()
    }

    single<LocalPermissionRepository> { LocalPermissionRepositoryImpl(get()) } withOptions {
        createdAtStart()
    }

    single<RemotePermissionRepository> { RemotePermissionRepositoryImpl(get(), get(), get(), get()) } withOptions {
        createdAtStart()
    }

    single<LocalUserInfoRepository> { LocalUserInfoRepositoryImpl(get()) } withOptions {
        createdAtStart()
    }

    single<RemoteUserInfoRepository> { RemoteUserInfoRepositoryImpl(get(), get(), get(), get()) } withOptions {
        createdAtStart()
    }
}