package domain.repository.token

import common.data.util.Result
import data.model.request.LoginRequestModel
import data.model.response.PrimaryResponse

interface RemoteTokenRepository {

    suspend fun login(loginRequestModel: LoginRequestModel): Result<PrimaryResponse<String?>>
}