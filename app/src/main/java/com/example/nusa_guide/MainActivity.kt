package com.example.nusa_guide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.nusa_guide.navigation.NavigationsTour
import com.example.nusa_guide.ui.theme.NusaGuideTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseApp.initializeApp(this)
        setContent {
            NusaGuideTheme {
                NavigationsTour()
            }
        }
    }
}
