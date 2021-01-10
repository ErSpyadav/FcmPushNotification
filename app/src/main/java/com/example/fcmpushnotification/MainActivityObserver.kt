package com.example.fcmpushnotification

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

class MainActivityObserver : LifecycleObserver {
    private  val TAG = "MainActivityObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun generateToken(){
        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.d(TAG, "generateToken failed ${task.exception}")
                return@OnCompleteListener
            }
            //get generate token
            val task = task.result?.token
            Log.d(TAG, "generateToken:\n"+task)
        })
    }
}