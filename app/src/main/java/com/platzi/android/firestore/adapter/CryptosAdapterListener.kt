package com.platzi.android.firestore.adapter

import com.platzi.android.firestore.model.Crypto

interface CryptosAdapterListener {
    fun onBuyCryptoClicked(crypto: Crypto)
}