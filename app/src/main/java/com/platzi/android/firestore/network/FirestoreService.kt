package com.platzi.android.firestore.network

import com.google.firebase.firestore.FirebaseFirestore
import com.platzi.android.firestore.model.Crypto
import com.platzi.android.firestore.model.User

//definir todas las funciones que utiliza el modulo de firestore
// se crean 2 constantes para facilitar el acceso a los nombres de las colecciones

const val CRYPTO_COLLECTION_NAME  ="cryptos"
const val USERS_COLLECTION_NAME  ="users"

class FirestoreService (val firebaseFirestore: FirebaseFirestore){
    // funcion para guardar documento
    fun setDocument(data: Any,collectionName : String, id : String,callback: Callback<Void>){

        firebaseFirestore.collection(collectionName).document(id).set(data)
            .addOnSuccessListener { callback.onSuccess(result = null) }
            .addOnFailureListener{exception -> callback.onFailed(exception)}
    }

    //actualizar el user

    fun updateUser(user : User,callback: Callback<User>?){
        firebaseFirestore.collection(USERS_COLLECTION_NAME).document(user.username)
            .update("cryptosList",user.cryptoList)
            .addOnSuccessListener { result ->
                if(callback != null)
                    callback.onSuccess(user)
            }
            .addOnFailureListener{exception -> callback!!.onFailed(exception)}
    }

    fun updateCrypto (crypto: Crypto){
        firebaseFirestore.collection(CRYPTO_COLLECTION_NAME).document(crypto.getDocumentId())
            .update("available", crypto.available)
    }
}