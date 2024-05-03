package com.example.bloodbank_compose.util

data class BloodbankBooking( val userId: String,
                             val name: String,
                             val phoneNumber: String,
                             val email: String,
    val date: String
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "displayName" to this.name,
            "phoneNumber" to this.phoneNumber,
            "email" to this.email,
            "date" to this.date

            )
    }

}
