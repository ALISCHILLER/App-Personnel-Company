package data.repository.permission

import data.database.datasource.UserPermissionDataSource
import data.database.room.entity.RoleEntity
import domain.repository.permission.LocalPermissionRepository

internal class LocalPermissionRepositoryImpl(
    private val userPermissionDataSource: UserPermissionDataSource
) : LocalPermissionRepository {

    override suspend fun removeAllUserPermission() {
        userPermissionDataSource.removeAllUserPermission()
    }

    override suspend fun selectUserPermission(permission: String) =
        userPermissionDataSource.selectUserPermission(permission = permission)

    override suspend fun insertUserPermission(roles: List<RoleEntity>) {
        userPermissionDataSource.insertUserPermission(roles = roles)
    }
}