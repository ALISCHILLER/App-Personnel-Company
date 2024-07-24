package domain.repository.userinfo

import data.database.room.entity.UserInfoEntity
import domain.model.ApiActions

interface RemoteUserInfoRepository {

    suspend fun getUserInfo(): ApiActions<UserInfoEntity>

}