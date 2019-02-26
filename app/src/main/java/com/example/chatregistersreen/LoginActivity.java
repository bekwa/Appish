package com.example.chatregistersreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatregistersreen.database.DataBaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText etemail , etpassword;
    private TextView tvCreateAccount;
    private Button btnLogin;
    private String Email, password, message;
    Utils util;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etEmail2);
        etpassword = findViewById(R.id.etPassword2);
        tvCreateAccount = findViewById(R.id.tvCreateaccount2);
        btnLogin = findViewById(R.id.btnLogin);
        util = new Utils();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //etemail.addTextChangedListener(Watcher);
                validate();

            }
        });
       tvCreateAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this , MainActivity.class));
           }
       });
    }

    private void validate() {

        db = new DataBaseHelper(getApplicationContext());

        Email = etemail.getText().toString().trim();
        password = etpassword.getText().toString().trim();

        if (TextUtils.isEmpty(password)){
            message = "Password field cannot be blank";
            etpassword.setError(message);
            return;}


        if (!util.isValidEmail(getApplicationContext(), Email)) {
            message = "Email field Cannot be blank";
            etemail.setError(message);
            return; }

        else startActivity(new Intent(LoginActivity.this , DashBoard.class));


            Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();


    }
}
