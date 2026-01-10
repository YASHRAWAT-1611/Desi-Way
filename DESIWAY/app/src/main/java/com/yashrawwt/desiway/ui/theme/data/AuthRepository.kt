package com.yashrawwt.desiway.ui.theme.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore

object AuthRepository {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    fun currentUser() = auth.currentUser

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onError(it.message ?: "Login failed") }
    }

    fun register(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                val user = auth.currentUser!!
                val data = mapOf(
                    "id" to user.uid,
                    "name" to name,
                    "email" to email
                )
                db.collection("users").document(user.uid).set(data)
                onSuccess()
            }
            .addOnFailureListener { onError(it.message ?: "Signup failed") }
    }

    fun googleSignIn(
        idToken: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener {
                val user = auth.currentUser!!
                val data = mapOf(
                    "id" to user.uid,
                    "name" to (user.displayName ?: ""),
                    "email" to (user.email ?: ""),
                    "photoUrl" to (user.photoUrl?.toString() ?: "")
                )
                db.collection("users").document(user.uid).set(data)
                onSuccess()
            }
            .addOnFailureListener {
                onError(it.message ?: "Google Sign-in failed")
            }
    }

    fun logout() {
        auth.signOut()
    }
}
