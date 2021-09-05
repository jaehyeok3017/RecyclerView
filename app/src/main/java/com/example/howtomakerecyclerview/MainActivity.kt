package com.example.howtomakerecyclerview

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.howtomakerecyclerview.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //array설정
        val list : ArrayList<Data> = ArrayList()

        binding.recycler.adapter = MainAdapter(list) { data, position ->
            list.removeAt(position)
            Toast.makeText(this, data.itemText, Toast.LENGTH_SHORT).show()
            binding.recycler.adapter!!.notifyItemRemoved(position)
        }

        binding.addBtn.setOnClickListener{
            val randomInt = Random.nextInt(100)
            list.add(Data("밥", randomInt.toString()))
            binding.recycler.adapter?.notifyItemInserted(list.size-1)
        }
    }

}