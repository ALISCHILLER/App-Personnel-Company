package data.database.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "UserInfo")
data class UserInfoEntity(
    val userName : String? = null,
    val fullName : String? = null,
    val personnelNumber : String? = null,
    val personnelJobKeyCode : String? = null,
    val personnelJobKeyText : String? = null,
    val companyCode : String? = null,
    val companyName : String? = null,
    val organizationUnit : String? = null,
    val phone : String? = null,
    val email : String? = null,
    val mobile : String? = null,
    val roles : List<String?>? = null,
    val userType : String? = null,
    var pelak : String? = null,
    var carModel : String? = null
) {
    @PrimaryKey(autoGenerate = false)
    var id : Int = 0
}

