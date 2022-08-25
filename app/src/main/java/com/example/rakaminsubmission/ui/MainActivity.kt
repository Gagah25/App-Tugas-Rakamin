package com.example.rakaminsubmission.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rakaminsubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DataAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = DataAdapter()

        binding.apply {
            rvData.layoutManager = LinearLayoutManager(this@MainActivity)
            rvData.setHasFixedSize(true)
            rvData.adapter = adapter
        }


        viewModel.getDataViewModel().observe(this) {
            if (it != null) {
                adapter.setList(it)
            }
        }
        viewModel.setData()
    }
}