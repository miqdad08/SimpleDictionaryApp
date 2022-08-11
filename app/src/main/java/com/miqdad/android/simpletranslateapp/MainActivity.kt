package com.miqdad.android.simpletranslateapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.miqdad.android.simpletranslateapp.api.network.ApiClient
import com.miqdad.android.simpletranslateapp.databinding.ActivityMainBinding
import com.miqdad.android.simpletranslateapp.ui.TranslateViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private lateinit var viewModel: TranslateViewModel

    private var definitionList = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TranslateViewModel::class.java]

        viewModel.getSearchUser().observe(this) {
            binding.tvWord.text = it[0].word
            binding.tvPhonetic.text = it[0].phonetic
            //untuk melakukan perulangan untuk mendapatkan definition dari meanings
            //di loop kembali dan mengambil definitions lalu mendapatkan definition
            //definition dimasukkan/ditambah ke variabel definitionLis
            it.get(0).meanings?.forEach {
                it?.definitions?.forEach {
                    definitionList += it?.definition
                }
            }
            //lalu panggil definitionlist yang tadi sudah kita masukkan definition
            binding.tvDefinition1.text = definitionList

        }

        getSearch()

    }

    private fun getSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.let {
                    viewModel.getSearchApi(it.toString())
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
}