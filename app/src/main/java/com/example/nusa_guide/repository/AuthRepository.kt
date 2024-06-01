package com.example.nusa_guide.repository

import android.content.Context
import com.example.nusa_guide.model.LoginModel
import com.example.nusa_guide.model.RegisterModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AuthRepository(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    context: Context
) {
    private val sharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun loginUser(loginModel: LoginModel, onComplete: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(loginModel.email, loginModel.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val editor = sharedPreferences.edit()
                    editor.putString("user_email", loginModel.email)
                    editor.putString("user_password", loginModel.password)
                    editor.apply()
                    onComplete(true, null)
                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }

    fun registerUser(
        registerModel: RegisterModel,
        onComplete: (Boolean, String?) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(registerModel.email, registerModel.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = auth.currentUser?.uid
                    if (userId != null) {
                        saveUserToFirestore(userId, registerModel, onComplete)
                    } else {
                        onComplete(false, "User ID is null")
                    }
                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }

    fun authLogout() {
        auth.signOut()
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun getSavedCredentials(): Pair<String, String>? {
        val email = sharedPreferences.getString("user_email", null)
        val password = sharedPreferences.getString("user_password", null)
        return if (email != null && password != null) Pair(email, password) else null
    }

    private fun saveUserToFirestore(
        userId: String,
        registerModel: RegisterModel,
        onComplete: (Boolean, String?) -> Unit
    ) {
        val user = hashMapOf(
            "name" to registerModel.nama,
            "email" to registerModel.email,
            "numberPhone" to registerModel.numberPhone,
        )

        firestore.collection("users").document(userId)
            .set(user)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onComplete(true, null)
                } else {
                    onComplete(false, task.exception?.message)
                }
            }
    }
}
