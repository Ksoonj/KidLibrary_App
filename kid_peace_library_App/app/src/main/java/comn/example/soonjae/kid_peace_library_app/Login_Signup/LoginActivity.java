package comn.example.soonjae.kid_peace_library_app.Login_Signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import comn.example.soonjae.kid_peace_library_app.Activity.MainActivity;
import comn.example.soonjae.kid_peace_library_app.ApiUtils;
=======
import java.util.ArrayList;

import comn.example.soonjae.kid_peace_library_app.DBHelper;
>>>>>>> b2ac5a375521cc7071ef8d99f364f0b95125ad80
import comn.example.soonjae.kid_peace_library_app.R;
import comn.example.soonjae.kid_peace_library_app.ResObj;
import comn.example.soonjae.kid_peace_library_app.service.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView move_signup;
    private EditText user_id;
    private EditText user_pwd;
    Button btn_login;
    UserService userService;

    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

<<<<<<< HEAD
        user_id = (EditText)findViewById(R.id.input_id);
        user_pwd = (EditText)findViewById(R.id.input_password);
        btn_login =(Button)findViewById(R.id.btn_login);

        userService = ApiUtils.getUserService();



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_id.getContext().toString();
                String password = user_pwd.getContext().toString();

                //validate form

                if(validateLogin(username,password)){
                    //do login
                    doLogin(username,password);
                }
            }
        });










=======
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

>>>>>>> b2ac5a375521cc7071ef8d99f364f0b95125ad80
        move_signup = (TextView)findViewById(R.id.link_signup);


        move_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });


    }

    private boolean validateLogin(String username , String userpassword){

    if(username == null || username.trim().length() == 0){

        Toast.makeText(this,"아이디를 입력하세요",Toast.LENGTH_SHORT).show();
        return false;
    }


        if(userpassword == null || userpassword.trim().length() == 0){

            Toast.makeText(this,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String username, final String password){

        Call<ResObj> call = userService.login(username,password);
        call.enqueue(new Callback<ResObj>() {
            @Override
            public void onResponse(Call<ResObj> call, Response<ResObj> response) {
                if(response.isSuccessful()) {
                    ResObj resObj = response.body();
                    if (resObj.getId().equals("true")) {

                        //Login start main activity
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("password",password);
                        startActivity(intent);

                    } else {

                        Toast.makeText(LoginActivity.this, "아이디 및 비밀번호를 다시확인해주세요", Toast.LENGTH_SHORT).show();
                    }

                }else{
                        Toast.makeText(LoginActivity.this,"Error", Toast.LENGTH_SHORT).show();
                    }
                }


            @Override
            public void onFailure(Call<ResObj> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
