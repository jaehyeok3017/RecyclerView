package com.example.howtomakerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.howtomakerecyclerview.databinding.RowItemBinding

class MainAdapter(val data : ArrayList<Data>, private val OnClick : (data : Data, position : Int) -> Unit) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    class MainViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)

        return MainViewHolder(RowItemBinding.bind(v))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
       holder.binding.data = data[position]
    }

    override fun getItemCount(): Int = data.size
}