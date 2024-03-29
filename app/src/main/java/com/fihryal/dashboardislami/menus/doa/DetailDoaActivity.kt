package com.fihryal.dashboardislami.menus.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.fihryal.dashboardislami.R
import com.fihryal.dashboardislami.databinding.ActivityDetailDoaBinding
import com.fihryal.dashboardislami.menus.doa.model.DoaModel

class DetailDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        // variable untuk menerima data dari kiriman adapter
        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_Doa) as DoaModel
        // menemukan actioanbar dengan toolbar pada layout
        setSupportActionBar(binding.toolbarDetailDoa)
        supportActionBar?.title = doa.title
        // menampilkan data ke masing-masing komponen layout
        binding.tvTitleDoa.text = doa.title
        binding.tvTitleArab.text = doa.doa
        binding.tvTitleArti.text = doa.translate
        binding.tvTitleLatin.text = doa.latin
        binding.tvTitleRiwayat.text = doa.profile
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_Doa = "extra_doa"
    }
}