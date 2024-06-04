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

    fun getPaketRekomendasiById(
        rekomendasiId: String,
        onComplete: (Rekomendasi) -> Unit,
        onError: (Exception) -> Unit
     ){
        firestore.collection("PaketRekomendasi")
            .document(rekomendasiId)
            .get()
            .addOnSuccessListener { document ->
                val rekomendasi = document.toObject(Rekomendasi::class.java)
                if (rekomendasi != null) {
                    onComplete(rekomendasi)
                } else {
                    onError(Exception("Rekomendasi not found"))
                }
            }
            .addOnFailureListener { exception ->
                onError(exception)
            }
    }
}