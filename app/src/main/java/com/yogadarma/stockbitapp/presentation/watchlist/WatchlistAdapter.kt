package com.yogadarma.stockbitapp.presentation.watchlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yogadarma.core.domain.model.Crypto
import com.yogadarma.stockbitapp.R
import com.yogadarma.stockbitapp.databinding.ItemCryptoBinding
import java.util.*

class WatchlistAdapter : RecyclerView.Adapter<WatchlistAdapter.ViewHolder>() {

    private var listData = ArrayList<Crypto>()

    fun setData(newListData: List<Crypto>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemCryptoBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder(private val binding: ItemCryptoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Crypto) {
            Glide.with(binding.root.context).load("https://www.cryptocompare.com/${data.imageUrl}")
                .into(binding.imgCrypto)
            binding.tvNameCrypto.text = data.name
            binding.tvFullnameCrypto.text = data.fullName
            binding.tvPriceCrypto.text = data.price
            binding.tvPercentageCrypto.text =
                binding.root.context.resources.getString(R.string.percentage_text, data.percentage)
            if (data.percentage[0] == '-') {
                binding.tvPercentageCrypto.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.red
                    )
                )
            } else {
                binding.tvPercentageCrypto.setTextColor(
                    ContextCompat.getColor(
                        binding.root.context,
                        R.color.green
                    )
                )
            }
        }
    }
}