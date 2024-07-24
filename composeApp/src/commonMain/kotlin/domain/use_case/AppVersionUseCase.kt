package domain.use_case

import data.model.response.AppVersionModel
import data.model.response.PrimaryResponse
import common.data.util.Result
import domain.repository.AppVersionRepository

class AppVersionUseCase(
    private val repository: AppVersionRepository
) {
    suspend operator fun invoke(): Result<PrimaryResponse<AppVersionModel>> {
        // validations
        return repository.getAppVersion()
    }

}