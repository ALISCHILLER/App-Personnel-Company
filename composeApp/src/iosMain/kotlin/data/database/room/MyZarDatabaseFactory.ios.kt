package data.database.room

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver


actual class MyZarDatabaseFactory {
    actual suspend fun createMyZarDatabase(): MyZarDatabase {
        val dbFilePath = "my_room.db"
        return Room.databaseBuilder<MyZarDatabase>(
            name = dbFilePath,
            factory = { MyZarDatabase::class.instantiateImpl }
        ).setDriver(BundledSQLiteDriver()).build()
    }
}