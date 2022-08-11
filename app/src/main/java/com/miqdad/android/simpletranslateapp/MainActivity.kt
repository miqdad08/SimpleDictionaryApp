package com.miqdad.android.simpletranslateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.miqdad.android.simpletranslateapp.api.data.DefinitionsItem
import com.miqdad.android.simpletranslateapp.api.data.TranslateResponseItem
import com.miqdad.android.simpletranslateapp.databinding.ActivityMainBinding
import com.miqdad.android.simpletranslateapp.ui.TranslateAdapter
import com.miqdad.android.simpletranslateapp.ui.TranslateViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private lateinit var viewModel: TranslateViewModel

    private var definitionList = ""
    private var translateAdapter = TranslateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[TranslateViewModel::class.java]

        viewModel.getSearchUser().observe(this) {

            if (it != null){
                it.get(0).meanings?.get(0)?.let { it1 -> setUpRecyclerView(it1.definitions as ArrayList<DefinitionsItem>) }
                binding.tvWord.text = it[0].word
                binding.tvPhonetic.text = it[0].phonetic
            }else{
                Toast.makeText(this, "Word Not Found", Toast.LENGTH_SHORT).show()
            }



            //untuk melakukan perulangan untuk mendapatkan definition dari meanings
            //di loop kembali dan mengambil definitions lalu mendapatkan definition
            //definition dimasukkan/ditambah ke variabel definitionLis
//            it.get(0).meanings?.forEach {
//                it?.definitions?.forEach {
//                    definitionList += it?.definition
//                }
//            }
            //lalu panggil definitionlist yang tadi sudah kita masukkan definition
//            binding.tvDefinition1.text = definitionList

        }

        getSearch()

    }

    fun setUpRecyclerView(data: ArrayList<DefinitionsItem>) {
        binding.rvDefinition.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = translateAdapter
            translateAdapter.setData(data)
        }
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