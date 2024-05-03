package com.example.bloodbank_compose.screens.Booking

import androidx.lifecycle.ViewModel
import com.example.bloodbank_compose.util.BloodbankBooking
import com.example.bloodbank_compose.util.BloodbankUsers
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class BookViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private fun bookAppointment(name: String, phone: String, email: String,date: String) {
        val userId = auth.currentUser?.uid
        val booking = BloodbankBooking(
            userId = userId.toString(),
            name = name,
            phoneNumber = phone,
            email = email,
            date = date
        ).toMap()

        FirebaseFirestore.getInstance()
            .collection("bookings")
            .add(booking)


    }
}