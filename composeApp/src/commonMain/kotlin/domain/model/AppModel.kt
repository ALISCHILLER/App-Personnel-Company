package domain.model

import org.jetbrains.compose.resources.DrawableResource

data class AppModel(
    val title: String,
    val description: String,
    val icon: DrawableResource,
    val onClick: () -> Unit
)
