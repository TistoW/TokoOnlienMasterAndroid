package com.inyongtisto.tokoonline.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.inyongtisto.tokoonline.R
import com.inyongtisto.tokoonline.adapter.AdapterKeranjang
import com.inyongtisto.tokoonline.adapter.AdapterProduk
import com.inyongtisto.tokoonline.room.MyDatabase

/**
 * A simple [Fragment] subclass.
 */
class KeranjangFragment : Fragment() {

    // dipangil sekali ketika aktivity aktif
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_keranjang, container, false)
        init(view)

        mainButton()
        return view
    }

    private fun displayProduk(){
        val myDb = MyDatabase.getInstance(requireActivity())
        val listProduk = myDb!!.daoKeranjang().getAll() as ArrayList

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvProduk.adapter = AdapterKeranjang(requireActivity(), listProduk)
        rvProduk.layoutManager = layoutManager
    }

    private fun mainButton(){
        btnDelete.setOnClickListener {

        }

        btnBayar.setOnClickListener {

        }
    }

    lateinit var btnDelete :ImageView
    lateinit var rvProduk :RecyclerView
    lateinit var tvTotal :TextView
    lateinit var btnBayar :TextView
    private fun init(view: View) {
        btnDelete = view.findViewById(R.id.btn_delete)
        rvProduk = view.findViewById(R.id.rv_produk)
        tvTotal = view.findViewById(R.id.tv_total)
        btnBayar = view.findViewById(R.id.btn_bayar)
    }

    override fun onResume() {
        displayProduk()
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
