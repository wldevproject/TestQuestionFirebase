package com.example.buttonnavigation.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buttonnavigation.model.SoalNo1Item
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<ArrayList<SoalNo1Item>>().apply {
        val database = Firebase.database
        val myRef = database.getReference("data").child("soal_no_1")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val dataSoal: ArrayList<SoalNo1Item> = arrayListOf()
                for (dataSnapshot1 in snapshot.children) {
                    val surveyor = dataSnapshot1.getValue(SoalNo1Item::class.java)
                    surveyor?.let { dataSoal.add(it) }
                }
                value = dataSoal
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("Notification ->>", "Failed to read value.", error.toException())
            }
        })
    }
    val text: LiveData<ArrayList<SoalNo1Item>> = _text

}