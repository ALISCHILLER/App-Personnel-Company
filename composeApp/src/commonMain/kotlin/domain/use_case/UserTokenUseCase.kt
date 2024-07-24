package domain.use_case

import data.database.room.entity.UserTokenEntity
import data.model.request.LoginRequestModel
import domain.repository.token.LocalTokenRepository
import domain.repository.token.RemoteTokenRepository
import kotlinx.coroutines.flow.Flow

class UserTokenUseCase(
    private val localTokenRepository: LocalTokenRepository,
    private val remoteTokenRepository: RemoteTokenRepository
) {

    suspend fun fullDeleteUser() = localTokenRepository.fullDeleteUser()

    suspend fun insertUserToken(userTokenEntity: UserTokenEntity) =
        localTokenRepository.insertUserToken(userTokenEntity = userTokenEntity)

    suspend fun selectAllUserToken(): Flow<List<UserTokenEntity>> =
        localTokenRepository.selectAllUserToken()

    suspend fun login(loginRequestModel: LoginRequestModel) =
        remoteTokenRepository.login(loginRequestModel = loginRequestModel)

}