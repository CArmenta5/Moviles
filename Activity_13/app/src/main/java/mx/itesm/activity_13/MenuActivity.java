package mx.itesm.activity_13;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private TextView tv_User, tv_changeable;
    private ImageButton ibtn_Friends,
                        ibtn_Hobbies,
                        ibtn_LMessage;

    private static final int EXAMPLE_CODE1 = 0;
    private static final int EXAMPLE_CODE2 = 0;
    private static final int EXAMPLE_CODE3 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();

        tv_User = findViewById(R.id.tv_User);
        ibtn_Friends =findViewById(R.id.ibtn_hobbies);
        ibtn_Hobbies = findViewById(R.id.ibtn_hobbies);
        ibtn_LMessage = findViewById(R.id.ibtn_LMessage);
        tv_changeable = findViewById(R.id.tv_changeable);
        tv_User.setText("HI "+ intent.getStringExtra("myName"));
        tv_changeable.setText(intent.getStringExtra("myHobbie"));

    }
    public void buttonClickFriends(View v){
        //  Toast.makeText(this,et_Name.getText(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,FriendsActivity.class);

        //startActivity(i); doesnt care if the activity ends

        startActivityForResult(i,EXAMPLE_CODE1);
    }
    public void buttonClickHobbies(View v){
        //  Toast.makeText(this,et_Name.getText(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,HobbiesActivity.class);
        Intent intent = getIntent();

        i.putExtra("myName", intent.getStringExtra("myName"));



        //startActivity(i); doesnt care if the activity ends

        startActivityForResult(i,EXAMPLE_CODE2);
    }
    public void buttonClickLeaveMessage(View v){
        //  Toast.makeText(this,et_Name.getText(),Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,LeaveMessageActivity.class);
        Intent intent = getIntent();

        i.putExtra("myName", intent.getStringExtra("myName"));
        i.putExtra("myHobbie", intent.getStringExtra("myHobbie"));

        startActivityForResult(i,EXAMPLE_CODE3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}