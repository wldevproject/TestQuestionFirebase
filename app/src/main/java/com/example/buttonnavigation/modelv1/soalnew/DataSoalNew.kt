package com.example.buttonnavigation.modelv1.soalnew

object DataSoalNew {
    val test = arrayListOf(0, 0, 0)

    private val map = mapOf(
        "1. Pemasukan/penghasilan" to mapOf(
            "a. <500 - 1000" to "100",
            "b. 1000 - 1500" to "80",
            "c. 1500 - 2000" to "60",
            "d. 2000 - 3000" to "40",
            "e. >3000" to "20"
        ),
        "2. Tingkat daya Listrik" to mapOf(
            "a. 220 VA" to "100",
            "b. 450 VA s.d. 900 VA" to "80",
            "c. 1.300 VA" to "60",
            "d. 2.200 VA" to "40",
            "e. > 2.200 VA" to "20"
        ),
        "3. Golongan atau kategori pelanggan" to mapOf(
            "a. golongan sosial" to "100",
            "b. golongan bisnis" to "60",
            "c. golongan bisnis" to "20"
        )
    )

    val soalSemua: List<SoalnyaNew>
        get() {
            return map.map { (key, value) -> SoalnyaNew(key, value) }
        }


    //    val soalSemua1: ArrayList<Soalnya>
//        get() {
//            val items = ArrayList<Soalnya>()
//            map.map { (key, value) ->
//                val item = Soalnya(key, value)
//                items += item
//            }
//            return items
//        }
}