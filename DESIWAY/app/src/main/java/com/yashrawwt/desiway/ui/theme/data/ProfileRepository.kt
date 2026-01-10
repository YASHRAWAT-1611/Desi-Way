package com.yashrawwt.desiway.ui.theme.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.yashrawwt.desiway.ui.theme.models.UserProfile

object ProfileRepository {

    private val db = FirebaseFirestore.getInstance()
    private val uid get() = FirebaseAuth.getInstance().currentUser?.uid

    fun getProfile(
        onSuccess: (UserProfile) -> Unit,
        onError: (String) -> Unit
    ) {
        uid ?: return
        db.collection("users").document(uid!!)
            .get()
            .addOnSuccessListener {
                onSuccess(it.toObject(UserProfile::class.java) ?: UserProfile())
            }
            .addOnFailureListener {
                onError(it.message ?: "Failed to load profile")
            }
    }

    fun logout() {
        FirebaseAuth.getInstance().signOut()
    }
}
