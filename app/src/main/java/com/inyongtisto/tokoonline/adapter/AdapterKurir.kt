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

class AdapterKurir(var data: ArrayList<Costs>, var kurir: String, var listener: Listeners) : RecyclerView.Adapter<AdapterKurir.Holder>() {

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvLamaPengiriman = view.findViewById<TextView>(R.id.tv_lamaPengiriman)
        val tvBerat = view.findViewById<TextView>(R.id.tv_berat)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val layout = view.findViewById<LinearLayout>(R.id.layout)
        val rd = view.findViewById<RadioButton>(R.id.rd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kurir, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {

        val a = data[position]


        holder.rd.isChecked = a.isActive

        holder.tvNama.text = kurir + " " + a.service
        val cost = a.cost[0]
        holder.tvLamaPengiriman.text = cost.etd + " hari kerja"
        holder.tvHarga.text = Helper().gantiRupiah(cost.value)
        holder.tvBerat.text = "1 kg x " + Helper().gantiRupiah(cost.value)
//        holder.tvAlamat.text = a.alamat + ", " + a.kota + ", " + a.kecamatan + ", " + a.kodepos + ", (" + a.type + ")"
//
        holder.rd.setOnClickListener {
            a.isActive = true
            listener.onClicked(a, holder.adapterPosition)
        }
//
//        holder.layout.setOnClickListener {
//            a.isSelected = true
//            listener.onClicked(a)
//        }
    }

    interface Listeners {
        fun onClicked(data: Costs, index: Int)
    }

}