package com.example.buttonnavigation.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        val database = Firebase.database
        val myRef = database.getReference("message")

        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                value = snapshot.getValue<String>()
                Log.d("Notification ->>", "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                value = "Failed to read value."
                Log.w("Notification ->>", "Failed to read value.", error.toException())
            }
        })
    }
    val text: LiveData<String> = _text


}