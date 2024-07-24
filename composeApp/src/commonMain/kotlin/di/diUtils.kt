package di

import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module
import util.dispatcher.provideDispatcher
import util.logger.provideLogger

internal val diUtilsModule = module {
    factory { provideDispatcher() } withOptions {
        createdAtStart()
    }

    factory { provideLogger() } withOptions {
        createdAtStart()
    }
}