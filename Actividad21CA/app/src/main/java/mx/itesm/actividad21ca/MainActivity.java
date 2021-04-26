package mx.itesm.actividad21ca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener {
    private Handler handler;
    private RecyclerView recyclerView;
    private ArrayList<JSONObject> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Rquest*/
        handler = new Handler(Looper.getMainLooper(), this);

        /*Recycler*/
        data = new ArrayList<>();

    }

    public void doRequest(View v){
        // checar de manera local
        Request request = new Request("https://raw.githubusercontent.com/CArmenta5/Moviles/master/Friend.json", handler);
        request.start();


    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        String respuesta = msg.obj.toString();
        try {
            JSONArray dataFriends = new JSONArray(respuesta);
            for(int i = 0; i < dataFriends.length(); i++){
                JSONObject friend = dataFriends.getJSONObject(i);
                data.add(friend);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView = findViewById(R.id.recyclerView);
        FriendAdapter adapter = new FriendAdapter(data,this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);


        return true;

    }

    @Override
    public void onClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);

        try {
            Toast.makeText(this,
                    "Friend: " +
                            data.get(pos).getString("nombre")+", "+
                            data.get(pos).getString("hobby")+", "+
                            data.get(pos).getInt("age")+", "+
                            data.get(pos).getInt("phone")+", "+
                            data.get(pos).getString("address")+" "
                    , Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}