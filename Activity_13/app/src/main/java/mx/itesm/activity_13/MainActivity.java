package mx.itesm.activity_13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //References to buttons and other controls on the layout
    private EditText et_Name;
    private Button btn_Press;
    private static final int EXAMPLE_CODE =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Name = findViewById(R.id.et_Name);
        btn_Press = findViewById(R.id.btn_Press);




    }
    public void buttonClick(View v){

        Intent i = new Intent(this,MenuActivity.class);
        i.putExtra("myName", et_Name.getText().toString() );//we send values

        startActivityForResult(i,EXAMPLE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}