package mx.itesm.activity_14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HobbiesActivity extends AppCompatActivity {
    private TextView tv_emptyHobbies,
                     tv_TituloHobbies;
    private EditText et_emptyHobbies;
    private Button btn_Hobbies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);

        tv_emptyHobbies = findViewById(R.id.tv_emptyHobbies);
        tv_TituloHobbies = findViewById(R.id.tv_TituloHobbies);
        et_emptyHobbies = findViewById(R.id.et_emptyHobbies);
        btn_Hobbies = findViewById(R.id.btn_Hobbies);

        viewOne();

        btn_Hobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel;
                userModel = new UserModel(-1,"",et_emptyHobbies.getText().toString());

                DataBaseHelper dataBaseHelper = new DataBaseHelper(HobbiesActivity.this);
                boolean success = dataBaseHelper.addOne(userModel);
                viewOne();
            }
        });

    }
    public void viewOne(){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(HobbiesActivity.this);
        List<UserModel> everyone =dataBaseHelper.getAll();
        if(everyone.size() == 0){
            tv_emptyHobbies.setText("");
        }else{

            tv_emptyHobbies.setText(everyone.get(everyone.size()-1).getHobby().toString());
        }
    }

}