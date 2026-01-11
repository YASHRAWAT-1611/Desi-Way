package com.yashrawwt.desiway.ui.theme.screens.auth

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.yashrawwt.desiway.ui.theme.auth.GoogleSignInHelper
import com.yashrawwt.desiway.ui.theme.data.AuthRepository

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(false) }

    val context = LocalContext.current

    /* ---------- GOOGLE SIGN-IN RESULT ---------- */
    val googleLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        loading = false
        if (result.resultCode == Activity.RESULT_OK) {
            try {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                val account = task.result
                val idToken = account.idToken!!

                AuthRepository.googleSignIn(
                    idToken = idToken,
                    onSuccess = onLoginSuccess,
                    onError = { error = it }
                )
            } catch (e: Exception) {
                error = e.message ?: "Google sign-in failed"
            }
        }
    }

    /* ---------- UI ---------- */
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                loading = true
                error = null
                AuthRepository.login(
                    email = email,
                    password = password,
                    onSuccess = {
                        loading = false
                        onLoginSuccess()
                    },
                    onError = {
                        loading = false
                        error = it
                    }
                )
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !loading
        ) {
            Text(if (loading) "Please wait..." else "Login")
        }

        Spacer(Modifier.height(8.dp))

        TextButton(
            onClick = onRegisterClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Don’t have an account? Register")
        }

        Spacer(Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                error = null
                loading = true
                val client = GoogleSignInHelper.getClient(context)
                googleLauncher.launch(client.signInIntent)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !loading
        ) {
            Text("Continue with Google")
        }

        error?.let {
            Spacer(Modifier.height(12.dp))
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}
