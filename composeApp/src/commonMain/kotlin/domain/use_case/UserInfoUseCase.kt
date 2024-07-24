package domain.use_case

import data.database.room.entity.UserInfoEntity
import domain.repository.userinfo.LocalUserInfoRepository
import domain.repository.userinfo.RemoteUserInfoRepository
import kotlinx.coroutines.flow.Flow

class UserInfoUseCase(
    private val localUserInfoRepository: LocalUserInfoRepository,
    private val remoteUserInfoRepository: RemoteUserInfoRepository
) {

    suspend fun requestGetUserInfo() =
        remoteUserInfoRepository.getUserInfo()

    suspend fun removeAllUserInfo() = localUserInfoRepository.removeAllUserInfo()

    suspend fun selectAllUserInfo(): Flow<UserInfoEntity?> =
        localUserInfoRepository.selectAllUserInfo()

    suspend fun insertUserInfo(userInfoEntity: UserInfoEntity) =
        localUserInfoRepository.insertUserInfo(userInfoEntity = userInfoEntity)

}