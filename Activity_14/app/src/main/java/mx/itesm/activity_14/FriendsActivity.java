package mx.itesm.activity_14;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FriendsActivity extends AppCompatActivity {

    private Button btn_Delete,
                    btn_Search,
                    btn_Save;
    private TextView tv_TituloFriends;
    private EditText et_nameName,
                    et_nameHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        btn_Delete = findViewById(R.id.btn_Delete);
        btn_Search = findViewById(R.id.btn_Search);
        btn_Save = findViewById(R.id.btn_Save);

        et_nameName = findViewById(R.id.et_nameName);
        et_nameHobby = findViewById(R.id.et_nameHobby);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel;
                userModel = new UserModel(-1,et_nameName.getText().toString(),et_nameHobby.getText().toString());

                DataBaseHelper dataBaseHelper = new DataBaseHelper(FriendsActivity.this);
                boolean success = dataBaseHelper.addOne(userModel);
            }
        });
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(FriendsActivity.this);

                List<UserModel> everyone =dataBaseHelper.getAll();
                boolean success =  dataBaseHelper.deleteOne(et_nameName.getText().toString(), et_nameHobby.getText().toString());

            }
        });
        btn_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(FriendsActivity.this);

                long success =  dataBaseHelper.searchOne(et_nameName.getText().toString());

                List<UserModel> everyone = dataBaseHelper.getAll();
                int index= (int) success;

                et_nameHobby.setText( everyone.get(index-1).getHobby().toString());

            }
        });

    }
}