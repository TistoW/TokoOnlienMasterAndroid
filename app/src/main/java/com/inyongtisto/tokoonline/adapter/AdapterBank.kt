package com.inyongtisto.tokoonline.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.inyongtisto.tokoonline.MainActivity
import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.activity.DetailProdukActivity
import com.inyongtisto.tokoonline.activity.LoginActivity
import com.inyongtisto.tokoonline.helper.Helper
import com.inyongtisto.tokoonline.model.Alamat
import com.inyongtisto.tokoonline.model.Bank
import com.inyongtisto.tokoonline.model.Produk
import com.inyongtisto.tokoonline.model.rajaongkir.Costs
import com.inyongtisto.tokoonline.model.rajaongkir.Result
import com.inyongtisto.tokoonline.room.MyDatabase
import com.inyongtisto.tokoonline.util.Config
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterBank(var data: ArrayList<Bank>, var listener: Listeners) : RecyclerView.Adapter<AdapterBank.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val layout = view.findViewById<LinearLayout>(R.id.layout)
        val image = view.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {

        val a = data[position]
        holder.tvNama.text = a.nama
        holder.image.setImageResource(a.image)
        holder.layout.setOnClickListener {
            listener.onClicked(a, holder.adapterPosition)
        }
    }

    interface Listeners {
        fun onClicked(data: Bank, index: Int)
    }

}