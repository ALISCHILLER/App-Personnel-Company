package data.database.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.database.room.entity.UserTokenEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserTokenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserToken(userTokenEntity: UserTokenEntity)

    @Query("SELECT * FROM UserToken")
    fun getAllUserToken(): Flow<List<UserTokenEntity>>

    @Query("DELETE FROM UserToken")
    suspend fun deleteAll()


    @Query("SELECT * FROM UserToken limit 1")
    suspend fun getUserToken(): UserTokenEntity?

}