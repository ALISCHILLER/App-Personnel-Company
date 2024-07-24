package data.service

import common.data.KtorApi
import data.database.room.entity.UserInfoEntity
import domain.model.ApiActions
import data.model.response.PrimaryResponse
import data.model.response.UserInfoModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header

internal class UserInfoService : KtorApi() {
    suspend fun get(token: String) = try {
        val response = client.get {
            header(key = "Authorization", value = token)
            endPoint(path = "/logIn/login-userInfo")
        }.body<PrimaryResponse<UserInfoEntity>>()
        ApiActions(data = response.data)
    }catch (e: Exception) {
        handleException(ex = e)
    }
}