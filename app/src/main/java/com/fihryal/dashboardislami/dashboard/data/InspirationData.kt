package com.fihryal.dashboardislami.dashboard.data

import com.fihryal.dashboardislami.R
import com.fihryal.dashboardislami.dashboard.model.InspirationModel
import java.util.ArrayList

object InspiratonData {
    private val inspirationImage = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration
    )

    val listData: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImage.indices) {
                val inspiratio = InspirationModel()
                inspiratio.inspirationImage = inspirationImage[position]
                list.add(inspiratio)
            }
            return list
        }
}

