package mx.itesm.actividad21ca;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {
    private ArrayList<JSONObject> data;
    private View.OnClickListener listener;

    public FriendAdapter(ArrayList<JSONObject> data, View.OnClickListener listener){
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        v.setOnClickListener(listener);
        return  new FriendViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        try {
            holder.tvRowName.setText(data.get(position).getString("nombre"));
            holder.tvRowHobby.setText(data.get(position).getString("hobby"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

       /* try {
            holder.tvRowHobby.setText(data.get(position).getString("nombre"));
            holder.tvRowName.setText(data.get(position).getString("hobby"));

        } catch (JSONException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class FriendViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRowName, tvRowHobby;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRowName = itemView.findViewById(R.id.tvRowName);
            tvRowHobby = itemView.findViewById(R.id.tvRowHobby);
        }
    }

}
