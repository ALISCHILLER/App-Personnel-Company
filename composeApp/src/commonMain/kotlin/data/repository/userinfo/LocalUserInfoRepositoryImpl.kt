package data.repository.userinfo

import data.database.datasource.UserInfoDataSource
import data.database.room.entity.UserInfoEntity
import domain.repository.userinfo.LocalUserInfoRepository

internal class LocalUserInfoRepositoryImpl(
    private val userInfoDataSource: UserInfoDataSource
) : LocalUserInfoRepository {

    override suspend fun removeAllUserInfo() {
        userInfoDataSource.removeAllUserInfo()
    }

    override suspend fun selectAllUserInfo() = userInfoDataSource.selectAllUserInfo()

    override suspend fun insertUserInfo(userInfoEntity: UserInfoEntity) {
        userInfoDataSource.insertUserInfo(userInfoEntity = userInfoEntity)
    }
}