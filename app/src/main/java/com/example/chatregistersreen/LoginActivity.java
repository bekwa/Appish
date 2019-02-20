package com.example.chatregistersreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etemail , etpassword;
    private TextView tvCreateAccount;
    private Button btnLogin;
    private String Email, password;
    Utils util;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etEmail2);
        etpassword = findViewById(R.id.etPassword2);
        tvCreateAccount = findViewById(R.id.tvCreateaccount2);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , DashBoard.class));

                validate();
                Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_LONG).show();
                //etemail.addTextChangedListener(Watcher);
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

        Email = etemail.getText().toString().trim();
        password = etpassword.getText().toString().trim();

        if (Email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "field is empty", Toast.LENGTH_SHORT).show();}





    }
}
