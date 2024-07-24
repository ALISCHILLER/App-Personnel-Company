package domain.repository

import data.model.response.AppVersionModel
import data.model.response.PrimaryResponse
import common.data.util.Result

interface AppVersionRepository {

    suspend fun getAppVersion(): Result<PrimaryResponse<AppVersionModel>>

}