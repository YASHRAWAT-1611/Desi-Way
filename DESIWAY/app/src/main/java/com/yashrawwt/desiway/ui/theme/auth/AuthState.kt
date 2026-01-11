package com.yashrawwt.desiway.ui.theme.auth

data class AuthState(
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val error: String? = null
)
