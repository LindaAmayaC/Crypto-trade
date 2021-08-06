package com.platzi.android.firestore.network

import java.lang.Exception

interface RealtimeDataListener <T>{
    fun onDataChange(updateData: T)

    fun onError(exception: Exception)
}