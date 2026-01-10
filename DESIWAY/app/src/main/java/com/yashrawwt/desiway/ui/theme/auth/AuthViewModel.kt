package com.yashrawwt.desiway.ui.theme.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yashrawwt.desiway.ui.theme.data.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _authState = MutableStateFlow(AuthState())
    val authState: StateFlow<AuthState> = _authState

    init {
        checkUser()
    }

    private fun checkUser() {
        _authState.value = _authState.value.copy(
            isAuthenticated = AuthRepository.currentUser() != null
        )
    }

    /* ---------- EMAIL LOGIN ---------- */
    fun login(email: String, password: String) {
        _authState.value = AuthState(isLoading = true)

        AuthRepository.login(
            email = email,
            password = password,
            onSuccess = {
                _authState.value = AuthState(isAuthenticated = true)
            },
            onError = {
                _authState.value = AuthState(error = it)
            }
        )
    }

    /* ---------- REGISTER ---------- */
    fun register(name: String, email: String, password: String) {
        _authState.value = AuthState(isLoading = true)

        AuthRepository.register(
            name = name,
            email = email,
            password = password,
            onSuccess = {
                _authState.value = AuthState(isAuthenticated = true)
            },
            onError = {
                _authState.value = AuthState(error = it)
            }
        )
    }

    /* ---------- LOGOUT ---------- */
    fun logout() {
        AuthRepository.logout()
        _authState.value = AuthState()
    }

    /* ---------- GOOGLE SIGN IN ---------- */
    fun googleSignIn(idToken: String) {
        _authState.value = AuthState(isLoading = true)

        AuthRepository.googleSignIn(
            idToken = idToken,
            onSuccess = {
                _authState.value = AuthState(isAuthenticated = true)
            },
            onError = {
                _authState.value = AuthState(error = it)
            }
        )
    }

    fun clearError() {
        _authState.value = _authState.value.copy(error = null)
    }
}
