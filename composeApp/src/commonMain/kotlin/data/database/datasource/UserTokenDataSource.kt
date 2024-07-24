package data.database.datasource

import data.database.dataset.TokenDataSet
import data.database.room.entity.UserTokenEntity
import kotlinx.coroutines.flow.Flow

class UserTokenDataSource(
    private val tokenDataSet: TokenDataSet
) {

    suspend fun insertUserToken(userTokenEntity: UserTokenEntity) {
        tokenDataSet.insertUserToken(userTokenEntity = userTokenEntity)
    }

    suspend fun selectAllUserToken(): Flow<List<UserTokenEntity>> {
        return tokenDataSet.selectAllUserToken()
    }

    suspend fun fullDeleteUser() {
        return tokenDataSet.fullDeleteUser()
    }

    suspend fun selectUserToken(): UserTokenEntity? {
        return tokenDataSet.selectUserToken()
    }

}