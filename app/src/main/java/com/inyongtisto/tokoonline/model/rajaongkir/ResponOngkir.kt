package com.inyongtisto.tokoonline.model.rajaongkir

import com.inyongtisto.tokoonline.model.ModelAlamat

class ResponOngkir {
    val rajaongkir = Rajaongkir()

    class Rajaongkir{
        val results = ArrayList<Result>()
    }

}