package data.repository.token


import common.data.util.Result
import data.database.room.entity.UserTokenEntity
import data.model.request.LoginRequestModel
import data.service.LoginService
import data.model.response.PrimaryResponse
import domain.repository.token.LocalTokenRepository
import domain.repository.token.RemoteTokenRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

internal class RemoteTokenRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val loginService: LoginService,
    private val localTokenRepository: LocalTokenRepository
): RemoteTokenRepository {

    override suspend fun login(loginRequestModel: LoginRequestModel): Result<PrimaryResponse<String?>> {
        return withContext(dispatcherProvider.io) {
            try {
                localTokenRepository.fullDeleteUser()
                delay(500)
                val response = loginService.login(loginRequestModel = loginRequestModel)
                response.data?.let {
                    val userTokenEntity = UserTokenEntity(
                        token = response.data,
                        userName = loginRequestModel.userName,
                        password = loginRequestModel.password
                    )
                    localTokenRepository.insertUserToken(userTokenEntity = userTokenEntity)
                }
                Result.Success(
                    data = response
                )
            }catch (e: Exception) {
                Result.Error(message = "${e.message}")
            }
        }
    }

}