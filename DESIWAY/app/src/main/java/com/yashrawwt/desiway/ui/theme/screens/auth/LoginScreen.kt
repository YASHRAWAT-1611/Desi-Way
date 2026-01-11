package com.yashrawwt.desiway.ui.theme.screens.auth

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

    val context = LocalContext.current

    // 🔑 Google Sign-In result handler
    val googleLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult()
        ) { result ->
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.result
                val idToken = account.idToken!!

                AuthRepository.googleSignIn(
                    idToken = idToken,
                    onSuccess = onLoginSuccess,
                    onError = { error = it }
                )
            } catch (e: Exception) {
                error = e.message
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                AuthRepository.login(
                    email = email,
                    password = password,
                    onSuccess = onLoginSuccess,
                    onError = { error = it }
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(Modifier.height(8.dp))

        TextButton(onClick = onRegisterClick) {
            Text("Don’t have an account? Register")
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val client = GoogleSignInHelper.getClient(context)
                googleLauncher.launch(client.signInIntent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continue with Google")
        }

        error?.let {
            Spacer(Modifier.height(12.dp))
            Text(it, color = MaterialTheme.colorScheme.error)
        }
    }
}
