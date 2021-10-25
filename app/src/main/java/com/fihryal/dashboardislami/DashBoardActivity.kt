package com.fihryal.dashboardislami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fihryal.dashboardislami.dashboard.adapter.InspirationListAdaptor
import com.fihryal.dashboardislami.dashboard.data.InspiratonData
import com.fihryal.dashboardislami.dashboard.model.InspirationModel
import com.fihryal.dashboardislami.databinding.ActivityDashboardBinding
import com.fihryal.dashboardislami.menus.doa.MenuDoaActivity
import com.fihryal.dashboardislami.menus.dzikir.MenuDzikirActivity
import com.fihryal.dashboardislami.menus.jadwalsholat.MenuJadwalSholatActivity
import com.fihryal.dashboardislami.menus.videokajian.MenuVideoKajianActivity
import com.fihryal.dashboardislami.menus.zakat.MenuDzakatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class DashBoardActivity : AppCompatActivity() {

    //variable untuk mengikat layout ke class
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //mendaftarkan layout activity_dashboard.xml
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        //variable view untuk menampung komponen layout
        val view = binding.root
        //menentukan tampilan dengan data yang ada di variable view (binding)
        setContentView(view)
        //memanggil fungsi
        initNavMenu()
        initRecyclerViewInspiration()
        initHeader()
    }

    //fungsi untuk mengubah activity
    private fun initNavMenu(){

        //memberikan perintah klik pada komponen iv_icon_menu_doa
        binding.ivIconMenuDoa.setOnClickListener {
            startActivity(Intent(this, MenuDoaActivity::class.java))
        }

        //memulai activity baru dengan intent sebagai pembawa alamat yang ingin dituju
        binding.ivIconMenuDzikir.setOnClickListener {
            startActivity(Intent(this, MenuDzikirActivity::class.java))
        }

        binding.ivIconMenuJadwalSholat.setOnClickListener {
            startActivity(Intent(this, MenuJadwalSholatActivity::class.java))
        }

        binding.ivIconMenuVideoKajian.setOnClickListener {
            startActivity(Intent(this, MenuVideoKajianActivity::class.java))
        }

        binding.ivIconMenuZakat.setOnClickListener {
            startActivity(Intent(this, MenuDzakatActivity::class.java))
        }
       
    }

    //fungsi untuk menampilkan data dari adapter ke mkomponen recycleview
    private fun initRecyclerViewInspiration() {

        // variable list untuk menampung data dari object InspirationData
        val list: ArrayList<InspirationModel> = arrayListOf()
        //memasukkan semua data ke dalam variable list
        list.addAll(InspiratonData.listData)

        //mmebuat object InspirationListAdaptor
        val inspirationAdapter = InspirationListAdaptor(list)
        //mengatur ukuran recycleview agar fix
        binding.rvInspiration.setHasFixedSize(true)
        //mengatur tampilan recycleview agar sejajar secara vertical
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        //memasang adaptor ke recycleview
        binding.rvInspiration.adapter = inspirationAdapter
    }

    private fun initHeader(){
        //membuat variable yang menampung data waktu sekarang
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH")
        val time = timeFormat.format(timeNow.time)

        when{
            time.toInt() in 0..6 -> {
               binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }
            time.toInt() in 7..12 -> {
               binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_morning)
            }
            time.toInt() in 13..18 -> {
               binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_afternoon)
            }
            time.toInt() in 19..23 -> {
               binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }

        }
    }
}
