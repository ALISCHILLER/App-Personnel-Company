package data.repository

import data.model.response.AppVersionModel
import domain.repository.AppVersionRepository
import data.service.AppVersionService
import data.model.response.PrimaryResponse
import common.data.util.Result
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

internal class AppVersionRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val appVersionService: AppVersionService
) : AppVersionRepository {
    override suspend fun getAppVersion(): Result<PrimaryResponse<AppVersionModel>> {
        return withContext(dispatcherProvider.io) {
            try {
                val response = appVersionService.getAppVersion()
                Result.Success(
                    data = response
                )
            } catch (e: Exception) {
                Result.Error(message = "OOPPPPPSSSSS--- ${e.message}")
            }
        }
    }
}