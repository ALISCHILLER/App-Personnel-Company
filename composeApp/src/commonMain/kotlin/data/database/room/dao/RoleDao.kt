package data.database.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import data.database.room.entity.RoleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoleDao {

    @Query("DELETE FROM Role")
    suspend fun deleteAllRecord()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(roleEntities: List<RoleEntity>)

    @Query("SELECT * FROM Role WHERE permission = :permission LIMIT 1")
    fun getPermission(permission : String) : Flow<RoleEntity?>

}