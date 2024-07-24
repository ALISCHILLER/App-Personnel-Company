package ui.screen.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.model.ApiActions
import domain.model.ErrorModel
import domain.use_case.UserInfoUseCase
import domain.use_case.UserPermissionUseCase
import domain.use_case.UserTokenUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import util.dispatcher.DispatcherProvider

class SplashViewModel(
    private val userTokenUseCase: UserTokenUseCase,
    private val dispatcherProvider: DispatcherProvider,
    private val userPermissionUseCase: UserPermissionUseCase,
    private val userInfoUseCase: UserInfoUseCase
) : ViewModel() {

    var userLogged by mutableStateOf(ApiActions<Boolean>())
        private set

    var splashStep by mutableStateOf(0.0f)
        private set

    //---------------------------------------------------------------------------------------------- checkUserLogged
    fun checkUserLogged() {
        viewModelScope.launch(dispatcherProvider.io) {
            splashStep = 0.0f
            userLogged = userLogged.copy(
                data = null,
                isLoading = true,
                message = null,
                unAuthorization = false,
                unAccess = false
            )
            userTokenUseCase.selectAllUserToken().collectLatest {items ->
                splashStep = 0.3f
                delay(2000)
                val token = if (items.isEmpty()) null else items.first().token
                if (token.isNullOrEmpty())
                    completeSplashStep(
                        data = false,
                        isLoading = false,
                        message = null,
                        unAuthorization = false,
                        unAccess = false
                    )
                else
                    getUserPermission()
            }
        }
    }
    //---------------------------------------------------------------------------------------------- checkUserLogged


    //---------------------------------------------------------------------------------------------- getUserPermission
    private fun getUserPermission() {
        viewModelScope.launch(dispatcherProvider.io) {
            splashStep = 0.6f
            val response = userPermissionUseCase.getUserPermission()
            response.data?.let { permissions ->
                if (permissions.isEmpty())
                    completeSplashStep(
                        data = false,
                        isLoading = false,
                        message = response.message,
                        unAuthorization = false,
                        unAccess = false
                    )
                else
                    getUserInfo()
            } ?: run {
                completeSplashStep(
                    data = false,
                    isLoading = response.isLoading,
                    message = response.message,
                    unAuthorization = response.unAuthorization,
                    unAccess = response.unAccess
                )
            }
        }
    }
    //---------------------------------------------------------------------------------------------- getUserPermission


    //---------------------------------------------------------------------------------------------- getUserInfo
    private fun getUserInfo() {
        viewModelScope.launch(dispatcherProvider.io) {
            splashStep = 0.9f
            val response = userInfoUseCase.requestGetUserInfo()
            val logged = response.data != null
            splashStep = 1.0f
            delay(1500)
            userLogged = userLogged.copy(
                data = logged,
                isLoading = response.isLoading,
                message = response.message,
                unAuthorization = response.unAuthorization,
                unAccess = response.unAccess
            )
        }
    }
    //---------------------------------------------------------------------------------------------- getUserInfo


    //---------------------------------------------------------------------------------------------- completeSplashStep
    private fun completeSplashStep(
        data: Boolean,
        isLoading: Boolean,
        message: ErrorModel?,
        unAuthorization: Boolean,
        unAccess: Boolean
    ) {
        viewModelScope.launch(dispatcherProvider.io) {
            CoroutineScope(dispatcherProvider.io).launch {
                while (splashStep + 0.3 < 1.0) {
                    splashStep += 0.3f
                    delay(1500)
                }
                splashStep = 1.0f
                delay(1500)
                userLogged = userLogged.copy(
                    data = data,
                    isLoading = isLoading,
                    message = message,
                    unAuthorization = unAuthorization,
                    unAccess = unAccess
                )
            }
        }
    }
    //---------------------------------------------------------------------------------------------- completeSplashStep


}