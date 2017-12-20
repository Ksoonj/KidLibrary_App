package comn.example.soonjae.kid_peace_library_app.Login_Signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import comn.example.soonjae.kid_peace_library_app.DBHelper;
import comn.example.soonjae.kid_peace_library_app.R;

public class LoginActivity extends AppCompatActivity {
private TextView move_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "login.db", null, 1);
        final EditText idtxt = (EditText)findViewById(R.id.input_id);
        final EditText pwtxt = (EditText)findViewById(R.id.input_password);
        ArrayList<String> IDList = new ArrayList<String>();

        Button loginbtn = (Button)findViewById(R.id.btn_login);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = idtxt.getText().toString();
                String pw = pwtxt.getText().toString();

                if (id.length()==0||pw.length() == 0){
                    Toast toast = Toast.makeText(LoginActivity.this, "아이디와 비밀번호는 필수입력사항입니다.");
                    toast.show();
                    return;
                }
                String sql = "SELECT id FROM "+ dbHelper.tableName
            }
        });

        move_signup = (TextView)findViewById(R.id.link_signup);


        move_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });

    }


}
