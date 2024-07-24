package data.database.dataset

import data.database.room.MyZarDatabaseFactory
import data.database.room.entity.RoleEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

//https://www.youtube.com/watch?v=iRlfJcnLFF8

class UserPermissionDataSet(
    private val myZarDatabaseFactory: MyZarDatabaseFactory,
    private val scope: CoroutineScope,
    private val dispatcherProvider: DispatcherProvider
) {
    suspend fun removeAllUserPermission() {
        scope.launch(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userRoleDao()
                .deleteAllRecord()
        }
    }

    suspend fun selectUserPermission(permission : String): Flow<RoleEntity?> {
        return withContext(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userRoleDao()
                .getPermission(permission = permission)
        }
    }

    suspend fun insertUserPermission(roles: List<RoleEntity>) {
        scope.launch(dispatcherProvider.io) {
            val roleDao = myZarDatabaseFactory
                .createMyZarDatabase()
                .userRoleDao()
            roleDao.deleteAllRecord()
            delay(500)
            roleDao.insert(roleEntities = roles)
        }
    }
}


