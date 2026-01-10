package com.yashrawwt.desiway.ui.theme.data

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
                val uid = it.user!!.uid
                val user = User(
                    id = uid,
                    name = name,
                    email = email
                )
                db.collection("users").document(uid).set(user)
                onSuccess()
            }
            .addOnFailureListener { onError(it.message ?: "Signup failed") }
    }

    fun logout() {
        auth.signOut()
    }
}
