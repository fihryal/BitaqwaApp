package com.fihryal.dashboardislami.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fihryal.dashboardislami.R
import com.fihryal.dashboardislami.dashboard.model.InspirationModel

class InspirationListAdaptor(private val listInspiration: ArrayList<InspirationModel>) :
    RecyclerView.Adapter<InspirationListAdaptor.ListViewHolder>() {

    //calss untuk mendaftarkan komponen pada layout dan memasukkan ke dalam variable
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //varable untuk berisi komponen ImageView pada layout tem_row_nspration.xml
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
    }

    //mendaftarkan tampilan / layout untuk menampilkan gambar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        //variable view berisi layout yang akan menamplakn data (item_row_inspration)
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_inspiration, parent, false)
        return ListViewHolder(view)
    }

    //memasang data ke komponen layout
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //memesukkan data berdasarkan posisinya ke dalam variable inspiration
        val inspiraton = listInspiration[position]

        Glide.with(holder.itemView.context)
            .load(inspiraton.inspirationImage)
            .into(holder.imgPhoto)
    }

    //menentukan jumlah data yang ingn ditampillkan
    override fun getItemCount(): Int {
        return listInspiration.size
    }
}

