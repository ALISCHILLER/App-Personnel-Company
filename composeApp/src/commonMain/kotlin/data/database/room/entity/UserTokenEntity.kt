package data.database.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserToken")
data class UserTokenEntity(
    val token: String?,
    val userName: String?,
    val password: String?
) {
    @PrimaryKey(autoGenerate = false)
    var id : Int = 0
}
