package domain.model

import domain.model.enums.EnumError


data class ErrorModel(
    val type : EnumError = EnumError.Warning,
    val message : String
)
