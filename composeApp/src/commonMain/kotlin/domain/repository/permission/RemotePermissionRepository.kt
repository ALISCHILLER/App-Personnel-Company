package domain.repository.permission

import domain.model.ApiActions

interface RemotePermissionRepository {

    suspend fun getUserPermission(): ApiActions<List<String>>

}