package comn.example.soonjae.kid_peace_library_app.Login_Signup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import comn.example.soonjae.kid_peace_library_app.R;


public class SignupActivity extends AppCompatActivity{

//    private EditText input_id;
//    private EditText input_password;
//    private EditText input_reEnterPassword;
//    private EditText input_name;
//    private EditText input_email;
//    private EditText input_mobile;
//
//    private Button btn_signup;
//    private TextView link_login;

    private WebView webView;  // Webview
    private WebSettings webSettings; //Webview Setting



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);



        //Webview Setting


        webView = (WebView)findViewById(R.id.signup_webview);   //linked Layor
        webView.setWebViewClient(new WebViewClient()); //if clicked, not new window;
        webSettings = webView.getSettings(); // apply detailed Setting
        webSettings.setJavaScriptEnabled(true); //allowed javascript

        webView.loadUrl("http://192.168.0.187:5000/");


//        setContentView(R.layout.activity_signup);
//
//        input_id = (EditText)findViewById(R.id.input_id);
//        input_password=(EditText)findViewById(R.id.input_password);
//        input_reEnterPassword =  (EditText)findViewById(R.id.input_reEnterPassword);
//        input_name = (EditText)findViewById(R.id.input_name);
//        input_email = (EditText)findViewById(R.id.input_email);
//        input_mobile = (EditText)findViewById(R.id.input_mobile);
//
//        btn_signup = (Button)findViewById(R.id.btn_signup);
//
//        btn_signup.setOnClickListener(this);
//        link_login.setOnClickListener(this);
   }

//
//    @Override
//    public void onClick(View v) {
//
//    }
}
