package data.database.room

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.koin.mp.KoinPlatform

actual class MyZarDatabaseFactory {
    actual suspend fun createMyZarDatabase(): MyZarDatabase {
        val appContext = KoinPlatform.getKoin().get<Context>()
        val dbFile = appContext.getDatabasePath("my_zar.db")
        return Room.databaseBuilder<MyZarDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
            .allowMainThreadQueries()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}