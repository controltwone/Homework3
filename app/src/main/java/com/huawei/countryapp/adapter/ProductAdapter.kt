package com.huawei.countryapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.bumptech.glide.Glide
import com.huawei.countryapp.R
import com.huawei.countryapp.databinding.ItemProductsBinding
import com.huawei.countryapp.model.Product

class ProductAdapter (var productList : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(var view: ItemProductsBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemProductsBinding>(inflater, R.layout.item_products,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.view.productName.text = productList[position].title
        holder.view.productPrice.text = productList[position].price
        Glide.with(holder.view.root).load(productList[position].image).into(holder.view.imageView2)

        //  Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList : List<Product>){
        productList = newList as ArrayList<Product>
        notifyDataSetChanged()
    }

}