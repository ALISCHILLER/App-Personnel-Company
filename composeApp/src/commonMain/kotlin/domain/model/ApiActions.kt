package domain.model

data class ApiActions<T>(
    val data: T? = null,
    val isLoading: Boolean = false,
    val unAuthorization: Boolean = false,
    val unAccess: Boolean = false,
    var message: ErrorModel? = null,
)
