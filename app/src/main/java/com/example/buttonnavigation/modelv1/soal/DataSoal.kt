package com.example.buttonnavigation.modelv1.soal

import com.example.buttonnavigation.modelv1.Soal

object DataSoal {
    val test = arrayListOf(0, 0, 0)

    private val noSatu = arrayOf(
        arrayOf("a. <500 - 1000", "100"),
        arrayOf("b. 1000 - 1500", "80"),
        arrayOf("c. 1500 - 2000", "60"),
        arrayOf("d. 2000 - 3000", "40"),
        arrayOf("e. >3000", "20")
    )

    private var noDua = arrayOf(
        arrayOf("a. 220 VA", "100"),
        arrayOf("b. 450 VA s.d. 900 VA", "80"),
        arrayOf("c. 1.300 VA", "60"),
        arrayOf("d. 2.200 VA", "40"),
        arrayOf("e. > 2.200 VA", "20")
    )

    private var noTiga = arrayOf(
        arrayOf("a. golongan sosial", "100"),
        arrayOf("b. golongan bisnis", "60"),
        arrayOf("c. golongan bisnis", "20")
    )


    private var semuaSoal = arrayOf(
        arrayOf("1. Pemasukan/penghasilan", soalNoSatu),
        arrayOf("2. Tingkat daya Listrik", soalNoDua),
        arrayOf("3. Golongan atau kategori pelanggan", soalNoTiga)
    )


    val soalSemua: ArrayList<Soalnya>
        get() {
            val items = ArrayList<Soalnya>()
            for (aData in semuaSoal) {
                val list = ArrayList<Soal>()
                for (aData1 in noSatu) {
                    val item1 = Soal(aData1[0], aData1[1])
                    list.add(item1)
                }
                val item = Soalnya(aData[0].toString(), list)
                items.add(item)
            }
            return items
        }

    val soalNoSatu: ArrayList<Soal>
        get() {
            val list = ArrayList<Soal>()
            for (aData in noSatu) {
                val item = Soal(aData[0], aData[0])
                list.add(item)
            }
            return list
        }

    val soalNoDua: ArrayList<Soal>
        get() {
            val list = ArrayList<Soal>()
            for (aData in noDua) {
                val item = Soal(aData[0], aData[0])
                list.add(item)
            }
            return list
        }

    val soalNoTiga: ArrayList<Soal>
        get() {
            val list = ArrayList<Soal>()
            for (aData in noTiga) {
                val item = Soal(aData[0], aData[0])
                list.add(item)
            }
            return list
        }
}