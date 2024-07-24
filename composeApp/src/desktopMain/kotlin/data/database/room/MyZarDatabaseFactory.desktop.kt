package data.database.room

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual class MyZarDatabaseFactory {
    actual suspend fun createMyZarDatabase(): MyZarDatabase {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "my_zar1.db")
        return Room.databaseBuilder<MyZarDatabase>(
            name = dbFile.absolutePath,
        ).setDriver(BundledSQLiteDriver()).build()
    }
}