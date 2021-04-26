package mx.itesm.activity_13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HobbiesActivity extends AppCompatActivity {
    private ImageView iv_Hobbie;
    private TextView tv_Question;
    private Button btn_SendHobbie;
    private EditText et_Hobbie;
    private static final int EXAMPLE_CODE =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);



        iv_Hobbie = findViewById(R.id.iv_Hobbie);
        tv_Question = findViewById(R.id.tv_Question);
        btn_SendHobbie = findViewById(R.id.btn_SendHobbie);
        et_Hobbie = findViewById(R.id.et_Hobbie);

        tv_Question.setText("what is your hobby?");
        btn_SendHobbie.setText("Send hobbie");

    }
    public void buttonClick(View v){
        Intent intent = getIntent();


        Intent i = new Intent(this, MenuActivity.class);
        i.putExtra("myHobbie",et_Hobbie.getText().toString() ); //we send values
        i.putExtra("myName", intent.getStringExtra("myName"));

        startActivityForResult(i, EXAMPLE_CODE);  //Expects a result from the newly request activity
    }
    //this guy listens for any activity we requested with starActivityForResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == EXAMPLE_CODE && resultCode== Activity.RESULT_OK){
            Toast.makeText(this,data.getStringExtra("GREETINGS"), Toast.LENGTH_SHORT).show();
        }
    }
}