package data.model.response

import kotlinx.serialization.Serializable

/**
 * Created by m-latifi on 11/26/2022.
 */

@Serializable
data class UserInfoModel(
    val userName : String?,
    val fullName : String?,
    val personnelNumber : String?,
    val personnelJobKeyCode : String?,
    val personnelJobKeyText : String?,
    val companyCode : String?,
    val companyName : String? = null,
    val organizationUnit : String?,
    val phone : String?,
    val email : String?,
    val mobile : String?,
    val roles : List<String>?,
    val userType : String?,
    var pelak : String?,
    var carModel : String?
)

