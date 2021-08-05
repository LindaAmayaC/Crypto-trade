package com.platzi.android.firestore.model
// se usa esta clase para mapear la estructura de la crypto moneda
class Crypto (var name : String = "", var imageUrl : String = "",var available : Int = 0) {

    fun getDocumentId() : String{
        //se crea una fun para convertir el nombre de la moneda en lowercase para usarlo mas adelante
        return name.toLowerCase()
    }
}