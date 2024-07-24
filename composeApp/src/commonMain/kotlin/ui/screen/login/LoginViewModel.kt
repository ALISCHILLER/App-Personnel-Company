package ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import domain.model.ApiActions
import domain.model.ErrorModel
import data.model.request.LoginRequestModel
import domain.model.enums.EnumError
import domain.use_case.UserTokenUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import util.dispatcher.DispatcherProvider

class LoginViewModel(
    private val userTokenUseCase: UserTokenUseCase,
    private val dispatcherProvider: DispatcherProvider
): ViewModel() {

    var userName = mutableStateOf("")
    var userNameError = mutableStateOf(false)
    var password = mutableStateOf("")
    var passwordError = mutableStateOf(false)
    var login by mutableStateOf(ApiActions<Boolean>())
        private set


    //---------------------------------------------------------------------------------------------- getToken
    fun getToken() {
        viewModelScope.launch(dispatcherProvider.io) {
            userNameError.value = userName.value.isEmpty()
            passwordError.value = password.value.isEmpty()
            if (userNameError.value || passwordError.value)
                return@launch
            login = login.copy(
                data = null,
                isLoading = true,
                message = null,
                unAuthorization = false,
                unAccess = false
            )
            val loginRequestModel = LoginRequestModel(
                userName = userName.value,
                password = password.value
            )
            val response = userTokenUseCase.login(loginRequestModel = loginRequestModel)
            delay(1000)
            val logged = response.data?.data != null
            val type = if (logged) EnumError.Done else EnumError.Warning
            val message = if (logged) response.data?.message ?: "" else response.message ?: ""
            login = login.copy(
                data = logged,
                isLoading = false,
                message = ErrorModel(type = type, message = message),
                unAuthorization = false,
                unAccess = false
            )
        }
    }
    //---------------------------------------------------------------------------------------------- getToken


}