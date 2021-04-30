package com.inyongtisto.tokoonline.model

class Chekout {
    lateinit var user_id: String
    lateinit var total_item: String
    lateinit var total_harga: String
    lateinit var name: String
    lateinit var phone: String
    lateinit var kurir: String
    lateinit var detail_lokasi: String
    lateinit var jasa_pengiriaman: String
    lateinit var ongkir: String
    lateinit var total_transfer: String
    lateinit var bank: String
    var produks = ArrayList<Item>()

    class Item {
        lateinit var id: String
        lateinit var total_item: String
        lateinit var total_harga: String
        lateinit var catatan: String
    }
}