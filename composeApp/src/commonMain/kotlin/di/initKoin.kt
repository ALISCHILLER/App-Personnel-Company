package di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            diUtilsModule,
            diViewModelsModule,
            diRepositoriesModule,
            diUseCasesModule,
            diServicesModule,
            diDatabaseModule
        )
    }
}
