package domain.repository.permission

import data.database.room.entity.RoleEntity
import kotlinx.coroutines.flow.Flow

interface LocalPermissionRepository {

    suspend fun removeAllUserPermission()

    suspend fun selectUserPermission(permission : String): Flow<RoleEntity?>

    suspend fun insertUserPermission(roles: List<RoleEntity>)

}