package com.rcapelli.catalogoonline.adapters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rcapelli.catalogoonline.R
import com.rcapelli.catalogoonline.databinding.ItemProductFoundBinding
import com.rcapelli.catalogoonline.models.SearchResult
import com.squareup.picasso.Picasso

class ProductViewHolder(private val itemBinding: ItemProductFoundBinding): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemBinding.root){
        fun bind(product: SearchResult, listener: (SearchResult)->Unit){
            val url : String = product.thumbnail
            var finalUrl = url
            if(url.contains("http://")){
                finalUrl= "https"+url.substring(4)
                product.thumbnail = finalUrl
            }

            Picasso.get()
                .load(finalUrl)
                .error(R.mipmap.ic_launcher_round)
                .into(itemBinding.imgProduct)
            itemBinding.tvProductPrice.text = "$" + product.price.toString()
            itemBinding.tvProductTitle.text = product.title
            itemBinding.root.setOnClickListener {
                listener(product)
            }
        }
    }

    class ProductsAdapter(var items: List<SearchResult> = mutableListOf(),
                          val listener: (SearchResult)->Unit): androidx.recyclerview.widget.RecyclerView.Adapter<ProductViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val itemBinding = ItemProductFoundBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ProductViewHolder(itemBinding)
        }

        override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
            holder.bind(items[position], listener)

        override fun getItemCount(): Int = items.size


    }