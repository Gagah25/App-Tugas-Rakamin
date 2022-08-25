package com.example.rakaminsubmission.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rakaminsubmission.databinding.ItemRowDataBinding
import com.example.rakaminsubmission.model.response.ItemsItem

class DataAdapter: RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private val list = ArrayList<ItemsItem>()

    inner class DataViewHolder(val binding: ItemRowDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ItemsItem){

            binding.apply {
                tvRowName.text = data.login
                Glide.with(itemView).load(data.avatarUrl).circleCrop().into(imgRowPhoto)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = ItemRowDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(data: ArrayList<ItemsItem>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}