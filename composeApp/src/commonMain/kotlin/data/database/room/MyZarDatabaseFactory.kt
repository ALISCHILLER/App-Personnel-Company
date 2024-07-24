package data.database.room

expect class MyZarDatabaseFactory() {
    suspend fun createMyZarDatabase(): MyZarDatabase
}