package data.database.datasource

import data.database.dataset.UserPermissionDataSet
import data.database.room.entity.RoleEntity
import kotlinx.coroutines.flow.Flow

class UserPermissionDataSource(
    private val userPermissionDataSet: UserPermissionDataSet
) {

    suspend fun selectUserPermission(permission : String): Flow<RoleEntity?> {
        return userPermissionDataSet.selectUserPermission(permission = permission)
    }


    suspend fun removeAllUserPermission() {
        return userPermissionDataSet.removeAllUserPermission()
    }


    suspend fun insertUserPermission(roles: List<RoleEntity>) {
        return userPermissionDataSet.insertUserPermission(roles = roles)
    }

}