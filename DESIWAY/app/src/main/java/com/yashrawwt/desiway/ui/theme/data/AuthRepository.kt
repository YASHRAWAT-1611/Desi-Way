package com.yashrawwt.desiway.ui.theme.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.yashrawwt.desiway.ui.theme.models.User

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
            .addOnFailureListener {
                onError(it.message ?: "Login failed")
            }
    }

    fun register(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { result ->
                val user = User(
                    id = result.user!!.uid,
                    name = name,
                    email = email
                )
                db.collection("users")
                    .document(user.id)
                    .set(user)
                    .addOnSuccessListener { onSuccess() }
            }
            .addOnFailureListener {
                onError(it.message ?: "Signup failed")
            }
    }

    fun logout() {
        auth.signOut()
    }

    fun googleSignIn(
        idToken: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        auth.signInWithCredential(credential)
            .addOnSuccessListener { result ->
                val firebaseUser = result.user!!

                val user = User(
                    id = firebaseUser.uid,
                    name = firebaseUser.displayName ?: "",
                    email = firebaseUser.email ?: "",
                    photoUrl = firebaseUser.photoUrl?.toString() ?: ""
                )

                db.collection("users")
                    .document(user.id)
                    .set(user)

                onSuccess()
            }
            .addOnFailureListener {
                onError(it.message ?: "Google Sign-In failed")
            }
    }
}
