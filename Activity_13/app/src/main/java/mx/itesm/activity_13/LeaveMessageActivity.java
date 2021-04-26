package mx.itesm.activity_13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class LeaveMessageActivity extends AppCompatActivity {
    private EditText et_MessageLM;
    private Button btn_sendLM;
    private ImageView iv_message;
    private TextView tv_MessageLM;
    private static final int EXAMPLE_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_message);

        et_MessageLM = findViewById(R.id.et_MessageLM);

    }
    public void buttonClick(View v){
        Toast.makeText(this, et_MessageLM.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();

        Intent i = new Intent(this,MenuActivity.class);
        i.putExtra("myName", intent.getStringExtra("myName"));
        i.putExtra("myHobbie", intent.getStringExtra("myHobbie"));

        startActivityForResult(i,EXAMPLE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}