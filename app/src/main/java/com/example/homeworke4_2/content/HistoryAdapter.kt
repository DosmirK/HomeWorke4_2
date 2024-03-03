package com.example.homeworke4_2.content

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworke4_2.databinding.ItemHistoryBinding
import com.example.homeworke4_2.remote.LoveModel

class HistoryAdapter( private var historyList:List<LoveModel>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(historyList[position])
    }

    override fun getItemCount() = historyList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setHistory(history: List<LoveModel>) {
        historyList = history
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(loveModel: LoveModel){
            binding.tvResult.text = loveModel.toString()
        }
    }
}
