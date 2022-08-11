package com.miqdad.android.simpletranslateapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miqdad.android.simpletranslateapp.api.data.DefinitionsItem
import com.miqdad.android.simpletranslateapp.api.data.TranslateResponseItem
import com.miqdad.android.simpletranslateapp.databinding.ItemDefinitionBinding

class TranslateAdapter: RecyclerView.Adapter<TranslateAdapter.ViewHolder>() {

    private val listDefinition = ArrayList<DefinitionsItem>()

    class ViewHolder(val itemDefinition : ItemDefinitionBinding): RecyclerView.ViewHolder(itemDefinition.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        ItemDefinitionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemDefinition.apply {
            with(listDefinition[position]){
                tvNumber.text = "${position + 1}. "
                tvDefinition.text = definition
            }
        }
    }

    override fun getItemCount(): Int = listDefinition.size

    fun setData(data: ArrayList<DefinitionsItem>){
        this.listDefinition.clear()
        this.listDefinition.addAll(data)
    }
}