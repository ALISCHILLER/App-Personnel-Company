package data.database.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.database.room.entity.UserInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInfo(userInfoEntity: UserInfoEntity)

    @Query("SELECT * FROM UserInfo LIMIT 1")
    fun getUserInfo(): Flow<UserInfoEntity?>

    @Query("DELETE FROM userinfo")
    suspend fun deleteAll()

}