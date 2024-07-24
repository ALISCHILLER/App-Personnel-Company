package data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class AppVersionModel(
    val id: Int,
    val currentVersion: Long,
    val fileName: String?
)
