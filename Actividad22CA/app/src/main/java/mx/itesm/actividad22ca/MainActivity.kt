package mx.itesm.actividad22ca

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var recyclerView: RecyclerView? = null
    private var data: ArrayList<JSONObject>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*Inicialización atributos*/
        data = ArrayList()
        recyclerView =  findViewById(R.id.recyclerView)
        val json = "[{'name':'burger', 'price':15, 'description':'a juicy burger!'},{'name':'hotdog', 'price':20, 'description':'an ok hot dog'},{'name':'tacos', 'price':12, 'description':'some pretty good tacos'},{'name':'torta', 'price':22, 'description':'nice torta'},{'name':'carne asada', 'price':50, 'description':'a great carne asada'}]"

        /*RecyclerView*/
        val menu  = JSONArray(json)
        for (i in 0 until menu.length()) {
            val platillo = menu.getJSONObject(i)
            data?.add(platillo)
        }

        val adapter = Adapter(data?: ArrayList(), this)
        recyclerView?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL ,false)
        recyclerView?.adapter = adapter

    }
    override fun onClick(v: View?) {
        val pos: Int = v?.let { recyclerView?.getChildLayoutPosition(it) } ?: 0
        try {
            Toast.makeText(
                this,
                "Description: " +
                        (data?.get(pos)?.getString("description") ?: "")
                , Toast.LENGTH_SHORT
            ).show()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}