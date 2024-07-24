package data.repository.userinfo

import data.database.room.entity.UserInfoEntity
import domain.model.ApiActions
import data.service.UserInfoService
import domain.repository.token.LocalTokenRepository
import domain.repository.userinfo.LocalUserInfoRepository
import domain.repository.userinfo.RemoteUserInfoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

internal class RemoteUserInfoRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val userInfoService: UserInfoService,
    private val localUserInfoRepository: LocalUserInfoRepository,
    private val localTokenRepository: LocalTokenRepository
): RemoteUserInfoRepository {
    override suspend fun getUserInfo(): ApiActions<UserInfoEntity> {
        val token = localTokenRepository.selectBearerUserToken()
        token?.let {
            return withContext(dispatcherProvider.io) {
                val response = userInfoService.get(token = token)
                response.data?.let {
                    localUserInfoRepository.insertUserInfo(userInfoEntity = it)
                }
                delay(1000)
                response
            }
        } ?: run {
            return ApiActions(unAuthorization = true)
        }
    }
}