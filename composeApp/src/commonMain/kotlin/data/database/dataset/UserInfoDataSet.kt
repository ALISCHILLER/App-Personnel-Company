package data.database.dataset

import data.database.room.MyZarDatabaseFactory
import data.database.room.entity.UserInfoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import util.dispatcher.DispatcherProvider

//https://www.youtube.com/watch?v=iRlfJcnLFF8

class UserInfoDataSet(
    private val myZarDatabaseFactory: MyZarDatabaseFactory,
    private val scope: CoroutineScope,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend fun removeAllUserInfo() {
        scope.launch {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userInfoDao()
                .deleteAll()
        }
    }


    suspend fun selectAllUserInfo(): Flow<UserInfoEntity?> {
        return withContext(dispatcherProvider.io) {
            myZarDatabaseFactory
                .createMyZarDatabase()
                .userInfoDao()
                .getUserInfo()
        }
    }


    suspend fun insertUserInfo(userInfoEntity: UserInfoEntity) {
        scope.launch(dispatcherProvider.io) {
            val userInfoDao = myZarDatabaseFactory
                .createMyZarDatabase()
                .userInfoDao()
            userInfoDao.deleteAll()
            delay(500)
            userInfoDao.insertUserInfo(userInfoEntity = userInfoEntity)
        }
    }

}


