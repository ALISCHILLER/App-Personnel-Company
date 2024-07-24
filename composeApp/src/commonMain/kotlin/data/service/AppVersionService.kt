package data.service

import data.model.response.AppVersionModel
import common.data.KtorApi
import data.model.response.PrimaryResponse
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class AppVersionService: KtorApi() {

    suspend fun getAppVersion(): PrimaryResponse<AppVersionModel> = client.get {
        endPoint(path = "/Files/files-get-appVersion")
    }.body()

}