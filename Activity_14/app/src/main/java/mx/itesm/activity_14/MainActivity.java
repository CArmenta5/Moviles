package mx.itesm.activity_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btn_LoadHobbies,
                   btn_LoadFriend;
    private TextView tv_Greeting;
    private static final int EXAMPLE_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_LoadHobbies = findViewById(R.id.btn_LoadHobbies);
        btn_LoadFriend = findViewById(R.id.btn_LoadFriend);
        tv_Greeting = findViewById(R.id.tv_Greeting);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
        List<UserModel> everyone =dataBaseHelper.getAll();

        tv_Greeting.setText(everyone.get(everyone.size()-1).getName()+" "+everyone.get(everyone.size()-1).getHobby());
    }
    public void buttonClick(View v){
        //  Toast.makeText(this,et_Name.getText(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,HobbiesActivity.class);
        //startActivity(i); doesnt care if the activity ends

        startActivityForResult(i,EXAMPLE_CODE);
    }
    public void buttonClick2(View v){
        //  Toast.makeText(this,et_Name.getText(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,FriendsActivity.class);
        //startActivity(i); doesnt care if the activity ends

        startActivityForResult(i,EXAMPLE_CODE);
    }

}