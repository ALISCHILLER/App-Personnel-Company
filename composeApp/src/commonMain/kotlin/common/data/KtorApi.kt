package common.data

import domain.model.ApiActions
import domain.model.ErrorModel
import domain.model.enums.EnumError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://app.zarholding.com:5081"
private const val version = "/Api/V1"

internal abstract class KtorApi {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value
                when (statusCode) {
                    in 300..399 -> throw RedirectResponseException(response,"RedirectResponseException")
                    in 400..499 -> throw ClientRequestException(response,response.body())
                    in 500..599 -> throw ServerResponseException(response,"ServerResponseException")
                }
                if (statusCode >= 600) {
                    throw ResponseException(response,"ResponseException")
                }
            }
            handleResponseException { cause: Throwable ->
                throw cause
            }
        }
    }

    //---------------------------------------------------------------------------------------------- endPoint
    fun HttpRequestBuilder.endPoint(path: String) {
        url {
            takeFrom(BASE_URL)
            path(version + path)
            contentType(ContentType.Application.Json)
        }
    }
    //---------------------------------------------------------------------------------------------- endPoint


    //---------------------------------------------------------------------------------------------- handleException
    fun <T>handleException(ex: Exception): ApiActions<T> {
        when(ex) {
            is RedirectResponseException -> {
                return ApiActions(message = ErrorModel(type = EnumError.Warning, message = ex.message))
            }
            is ClientRequestException -> {
                return ApiActions(
                    data = null,
                    message = ErrorModel(type = EnumError.Warning, message = ex.message) ,
                    unAuthorization = ex.response.status.value == 401,
                    unAccess = ex.response.status.value == 403
                )
            }
            is ServerResponseException -> {
                return ApiActions(
                    data = null,
                    message = ErrorModel(type = EnumError.Warning, message = ex.message)
                )
            }
            else -> {
                return ApiActions(
                    data = null,
                    message = ErrorModel(type = EnumError.Warning, message = ex.message ?: "")
                )
            }
        }
    }
    //---------------------------------------------------------------------------------------------- handleException


}