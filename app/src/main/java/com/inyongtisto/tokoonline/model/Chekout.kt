package com.inyongtisto.tokoonline.model

class Chekout {
    lateinit var user_id: String
    lateinit var total_item: String
    lateinit var total_harga: String
    lateinit var name: String
    lateinit var phone: String
    var produks = ArrayList<Item>()

    class Item {
        lateinit var id: String
        lateinit var total_item: String
        lateinit var total_harga: String
        lateinit var catatan: String
    }
}