package data.database.datasource

import data.database.dataset.UserInfoDataSet
import data.database.room.entity.UserInfoEntity
import data.database.room.entity.UserTokenEntity
import kotlinx.coroutines.flow.Flow

class UserInfoDataSource(
    private val userInfoDataSet: UserInfoDataSet
) {

    suspend fun selectAllUserInfo(): Flow<UserInfoEntity?> {
        return userInfoDataSet.selectAllUserInfo()
    }


    suspend fun removeAllUserInfo() {
        return userInfoDataSet.removeAllUserInfo()
    }


    suspend fun insertUserInfo(userInfoEntity: UserInfoEntity) {
        return userInfoDataSet.insertUserInfo(userInfoEntity = userInfoEntity)
    }

}