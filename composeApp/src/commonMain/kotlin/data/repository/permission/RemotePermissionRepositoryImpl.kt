package data.repository.permission

import data.database.room.entity.RoleEntity
import domain.model.ApiActions
import data.service.PermissionService
import domain.repository.permission.LocalPermissionRepository
import domain.repository.permission.RemotePermissionRepository
import domain.repository.token.LocalTokenRepository
import domain.use_case.UserTokenUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

internal class RemotePermissionRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val permissionService: PermissionService,
    private val localPermissionRepository: LocalPermissionRepository,
    private val localTokenRepository: LocalTokenRepository
): RemotePermissionRepository {
    override suspend fun getUserPermission(): ApiActions<List<String>> {
        val token = localTokenRepository.selectBearerUserToken()
        token?.let {
            return withContext(dispatcherProvider.io) {
                val response = permissionService.get(token = token)
                response.data?.let {permissions ->
                    val items = permissions.map { RoleEntity(permission = it) }
                    localPermissionRepository.insertUserPermission(roles = items)
                }
                delay(1000)
                response
            }
        } ?: run {
            return ApiActions(unAuthorization = true)
        }
    }
}