package data.service

import common.data.KtorApi
import domain.model.ApiActions
import data.model.response.PrimaryResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header

internal class PermissionService: KtorApi() {
    suspend fun get(token: String) = try {
        val response = client.get{
            header(key = "Authorization", value = token)
            endPoint(path = "/logIn/get-persmissions")
        }.body<PrimaryResponse<List<String>>>()
        ApiActions(data = response.data)
    }catch (e: Exception) {
        handleException(ex = e)
    }


}