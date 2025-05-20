package edu.unikom.exchangerateproject

//NIM : 10122908
//Nama : Nizar Ihza Zulkarnain
//Kelas : IF13
//Last Modified : 20/05/2025


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.unikom.exchangerateproject.adapter.ListExchangeAdapter
import edu.unikom.exchangerateproject.model.Exchange

class MainActivity : AppCompatActivity() {

    private lateinit var rvExchangeRates: RecyclerView
    private val list = ArrayList<Exchange>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvExchangeRates = findViewById(R.id.rv_exchange_rates)
        rvExchangeRates.setHasFixedSize(true)
        rvExchangeRates.layoutManager = LinearLayoutManager(this)

        list.addAll(getExchangeList())
        val adapter = ListExchangeAdapter(list)
        rvExchangeRates.adapter = adapter
    }

    private fun getExchangeList(): List<Exchange> {
        val country = resources.getStringArray(R.array.data_country)
        val buy = resources.getStringArray(R.array.data_buy)
        val sell = resources.getStringArray(R.array.data_sell)
        val flag = resources.obtainTypedArray(R.array.data_flag)

        val exchangeList = ArrayList<Exchange>()
        for (i in country.indices) {
            val exchange = Exchange(
                country = country[i],
                buy = buy[i],
                sell = sell[i],
                flag = flag.getResourceId(i, -1)
            )
            exchangeList.add(exchange)
        }

        flag.recycle() // Penting untuk menghindari memory leak
        return exchangeList
    }
}
