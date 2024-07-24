package data.database.dataset

import data.database.room.MyZarDatabaseFactory
import data.database.room.entity.UserTokenEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

//https://www.youtube.com/watch?v=iRlfJcnLFF8

class TokenDataSet(
    private val scope: CoroutineScope,
    private val dispatcherProvider: DispatcherProvider,
    private val myZarDatabaseFactory: MyZarDatabaseFactory
) {

    suspend fun fullDeleteUser() {
        scope.launch(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userTokenDao()
                .deleteAll()
        }
    }

    suspend fun insertUserToken(userTokenEntity: UserTokenEntity) {
        scope.launch(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userTokenDao()
                .insertUserToken(userTokenEntity = userTokenEntity)
        }
    }

    suspend fun selectAllUserToken(): Flow<List<UserTokenEntity>> {
        return withContext(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userTokenDao()
                .getAllUserToken()
        }
    }


    suspend fun selectUserToken(): UserTokenEntity? {
        return withContext(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userTokenDao()
                .getUserToken()
        }
    }

}


