package com.example.yhgg_refactoring

import com.google.firebase.FirebaseApp

class Application : android.app.Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(applicationContext)
    }
}