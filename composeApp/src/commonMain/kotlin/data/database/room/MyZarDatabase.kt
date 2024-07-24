package data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import data.database.room.converter.ListStringConverters
import data.database.room.dao.RoleDao
import data.database.room.dao.UserInfoDao
import data.database.room.dao.UserTokenDao
import data.database.room.entity.RoleEntity
import data.database.room.entity.UserInfoEntity
import data.database.room.entity.UserTokenEntity


@Database(entities = [UserTokenEntity::class, UserInfoEntity::class,RoleEntity::class], version = 1)
@TypeConverters(ListStringConverters::class)
abstract class MyZarDatabase: RoomDatabase() {
    abstract fun userTokenDao() : UserTokenDao
    abstract fun userInfoDao(): UserInfoDao
    abstract fun userRoleDao(): RoleDao
}