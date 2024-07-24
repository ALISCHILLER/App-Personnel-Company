package data.service

import common.data.KtorApi
import data.model.request.LoginRequestModel
import data.model.response.PrimaryResponse
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal class LoginService: KtorApi() {
    suspend fun login(loginRequestModel: LoginRequestModel): PrimaryResponse<String?> = client.post{
        setBody(loginRequestModel)
        contentType(ContentType.Application.Json)
        endPoint(path = "/LogIn/login-users")
    }.body()
}