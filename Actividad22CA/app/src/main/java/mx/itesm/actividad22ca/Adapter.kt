package mx.itesm.actividad22ca


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

open class Adapter (var data : ArrayList<JSONObject>, var listener : View.OnClickListener) : RecyclerView.Adapter<Adapter.AdapterViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false) as View
        v.setOnClickListener(listener)
        return AdapterViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.tvRowName?.text = data[position].getString("name")
        holder.tvRowPrice?.text=(data[position].getString("price"))

    }
    override fun getItemCount(): Int {
        return data.size
    }
    open class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvRowName: TextView? = itemView.findViewById(R.id.tvRowName)
        var tvRowPrice:TextView? = itemView.findViewById(R.id.tvRowPrice)

    }
}