package com.example.nusa_guide.repository

import com.example.nusa_guide.model.Rekomendasi
import com.google.firebase.firestore.FirebaseFirestore

class RekomendasiRepository(private val firestore: FirebaseFirestore) {
    fun getPaketRekomendasi(
        onComplete: (List<Rekomendasi>) -> Unit,
        onError: (Exception) -> Unit
    ) {
        firestore.collection("PaketRekomendasi")
            .get()
            .addOnSuccessListener { result ->
                val rekomendasiList = result.documents.mapNotNull { document ->
                    document.toObject(Rekomendasi::class.java)
                }
                onComplete(rekomendasiList)
            }
            .addOnFailureListener { exception ->
                onError(exception)
            }
    }
}