package com.platzi.android.firestore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.platzi.android.firestore.R
import com.platzi.android.firestore.model.Crypto
import com.squareup.picasso.Picasso
import java.util.ArrayList

class CryptosAdapter(val cryptosAdapterListener: CryptosAdapterListener) : RecyclerView.Adapter<CryptosAdapter.ViewHolder> (){

    var cryptoList : List<Crypto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypto = cryptoList[position]
        Picasso.get().load(crypto.imageUrl).into(holder.image)//se muestra la imagen en esa posicion
        holder.name.text = crypto.name
        holder.available.text = holder.itemView.context.getString(R.string.available_message, crypto.available.toString())
        holder.buyBotton.setOnClickListener{
            cryptosAdapterListener.onBuyCryptoClicked(crypto)
        }
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        //mapear todos los componentes que estan en la lista del crypto_Row
        var image = view.findViewById<ImageView>(R.id.image)
        var name = view.findViewById<TextView>(R.id.nameTextView)
        var available = view.findViewById<TextView>(R.id.availableTextView)
        var buyBotton = view.findViewById<TextView>(R.id.buyButton)
    }
}