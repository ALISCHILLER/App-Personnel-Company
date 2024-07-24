package domain.use_case

import data.database.room.entity.RoleEntity
import domain.repository.permission.LocalPermissionRepository
import domain.repository.permission.RemotePermissionRepository
import kotlinx.coroutines.flow.Flow

class UserPermissionUseCase(
    private val localPermissionRepository: LocalPermissionRepository,
    private val remotePermissionRepository: RemotePermissionRepository
) {

    suspend fun removeAllUserPermission() = localPermissionRepository.removeAllUserPermission()

    suspend fun selectUserPermission(permission: String): Flow<RoleEntity?> =
        localPermissionRepository.selectUserPermission(permission = permission)

    suspend fun insertUserPermission(roles: List<RoleEntity>) =
        localPermissionRepository.insertUserPermission(roles = roles)

    suspend fun getUserPermission() =
        remotePermissionRepository.getUserPermission()
}