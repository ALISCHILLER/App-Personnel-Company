package data.repository.token

import data.database.datasource.UserTokenDataSource
import data.database.room.entity.UserTokenEntity
import domain.repository.token.LocalTokenRepository
import kotlinx.coroutines.flow.Flow

internal class LocalTokenRepositoryImpl(
    private val userTokenDataSource: UserTokenDataSource
) : LocalTokenRepository {

    override suspend fun fullDeleteUser() {
        userTokenDataSource.fullDeleteUser()
    }

    override suspend fun insertUserToken(userTokenEntity: UserTokenEntity) =
        userTokenDataSource.insertUserToken(userTokenEntity = userTokenEntity)

    override suspend fun selectBearerUserToken(): String? {
        val userToken = userTokenDataSource.selectUserToken()
        return userToken?.let {
            "Bearer ${it.token}"
        }?: run {
            null
        }
    }

    override suspend fun selectAllUserToken() = userTokenDataSource.selectAllUserToken()

}