package domain.repository.token

import data.database.room.entity.UserTokenEntity
import kotlinx.coroutines.flow.Flow

interface LocalTokenRepository {

    suspend fun fullDeleteUser()

    suspend fun selectAllUserToken(): Flow<List<UserTokenEntity>>

    suspend fun insertUserToken(userTokenEntity: UserTokenEntity)

    suspend fun selectBearerUserToken(): String?
}