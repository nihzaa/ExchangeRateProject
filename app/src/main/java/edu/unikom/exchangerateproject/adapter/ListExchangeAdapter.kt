package edu.unikom.exchangerateproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.unikom.exchangerateproject.R
import edu.unikom.exchangerateproject.model.Exchange

class ListExchangeAdapter(
    private val listExchange: List<Exchange>
) : RecyclerView.Adapter<ListExchangeAdapter.ExchangeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_exchange, parent, false)
        return ExchangeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
        val exchange = listExchange[position]
        holder.imgFlag.setImageResource(exchange.flag)
        holder.txtCountry.text = exchange.country
        holder.txtBuy.text = exchange.buy
        holder.txtSell.text = exchange.sell
    }

    override fun getItemCount(): Int = listExchange.size

    class ExchangeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFlag: ImageView = itemView.findViewById(R.id.img_flag)
        val txtCountry: TextView = itemView.findViewById(R.id.txt_country)
        val txtBuy: TextView = itemView.findViewById(R.id.txt_buy)
        val txtSell: TextView = itemView.findViewById(R.id.txt_sell)
    }
}
