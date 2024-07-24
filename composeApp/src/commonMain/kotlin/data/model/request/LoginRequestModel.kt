package data.model.request

import kotlinx.serialization.Serializable

/**
 * Created by m-latifi on 11/9/2022.
 */

@Serializable
data class LoginRequestModel(
    val userName : String,
    val password : String
)
