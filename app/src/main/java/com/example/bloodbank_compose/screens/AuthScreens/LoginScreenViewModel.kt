package com.example.bloodbank_compose.screens.AuthScreens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodbank_compose.util.BloodbankUsers
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    //    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth

    var isLoading by mutableStateOf(false)

    var loginErr by mutableStateOf("")


    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
//_loading.value = true
            isLoading = true
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("FB", "signin good : ${task.result}")
                        home()
                    }
                    isLoading = false
                }.addOnFailureListener { result ->
                    Log.d("FB", "signin bad : ${result.message}")
                    loginErr = result.message.toString()
                }
        }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        name: String,
        phoneNumber: String,
        home: () -> Unit,

        ) = viewModelScope.launch {
        if (isLoading == false) {
            isLoading = true

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        createUser(name, phoneNumber, email)
                        home()

                        Log.d("create suc", "${task.result}")
                    }

                    isLoading = false
                }.addOnFailureListener { task ->
                    Log.d("fail", "${task.message}")
                    loginErr = task.message.toString()
                }

        }
    }

    private fun createUser(name: String, phoneNumber: String, email: String) {
        val userId = auth.currentUser?.uid
        val user = BloodbankUsers(
            userId = userId.toString(),
            name = name,
            phoneNumber = phoneNumber,
            email = email
        ).toMap()

        FirebaseFirestore.getInstance()
            .collection("user")
            .add(user)


    }
}