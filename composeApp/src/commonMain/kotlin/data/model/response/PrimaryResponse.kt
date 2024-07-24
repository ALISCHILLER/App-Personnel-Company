package data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PrimaryResponse<T>(
    val hasError : Boolean,
    val message : String,
    val data: T?
)