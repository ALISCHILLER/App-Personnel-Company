package di

import data.database.dataset.TokenDataSet
import data.database.dataset.UserInfoDataSet
import data.database.dataset.UserPermissionDataSet
import data.database.datasource.UserInfoDataSource
import data.database.datasource.UserPermissionDataSource
import data.database.datasource.UserTokenDataSource
import data.database.room.MyZarDatabaseFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

internal val diDatabaseModule = module {

    single { MyZarDatabaseFactory() } withOptions {
        createdAtStart()
    }

    single<CoroutineContext> { Dispatchers.Default } withOptions {
        createdAtStart()
    }

    single { CoroutineScope(get()) } withOptions {
        createdAtStart()
    }

    single { TokenDataSet(get(), get(), get()) } withOptions {
        createdAtStart()
    }

    single { UserTokenDataSource(get()) } withOptions {
        createdAtStart()
    }

    single { UserPermissionDataSet(get(), get(), get()) } withOptions {
        createdAtStart()
    }

    single { UserPermissionDataSource(get()) } withOptions {
        createdAtStart()
    }

    single { UserInfoDataSet(get(), get(), get()) } withOptions {
        createdAtStart()
    }

    single { UserInfoDataSource(get()) } withOptions {
        createdAtStart()
    }
}