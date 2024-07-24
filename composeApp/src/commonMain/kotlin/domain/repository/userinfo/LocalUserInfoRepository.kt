package domain.repository.userinfo

import data.database.room.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

interface LocalUserInfoRepository {

    suspend fun removeAllUserInfo()

    suspend fun selectAllUserInfo(): Flow<UserInfoEntity?>

    suspend fun insertUserInfo(userInfoEntity: UserInfoEntity)

}