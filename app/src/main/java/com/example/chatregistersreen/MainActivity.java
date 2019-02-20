package com.example.chatregistersreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstName , etSurname ,etPhone,  etUsername, etEmail, etPassword,etBirthDay ,  etloc  ;
    private Button btnSignUp ;
    private String  firstname , surname , email ,phone,Username, birthday, location ,password , fullName ;
    //private Spinner spGender;
    private String message;
    //private ImageButton ibPic;
    Utils util;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.etFirstname);
        etSurname = findViewById(R.id.etSurname);
        etBirthDay = findViewById(R.id.etBirthDay);
        etEmail = findViewById(R.id.etEmail);
        etloc = findViewById(R.id.etLocation);
        etPhone = findViewById(R.id.etPhone);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        //spGender = findViewById(R.id.spGender);
        btnSignUp = findViewById(R.id.btnSignup);

        util = new Utils();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent reg = new Intent(MainActivity.this , DashBoard.class);
                //startActivity(reg);

                startActivity(new Intent(MainActivity.this , DashBoard.class));

                validate();
                Toast.makeText(getApplicationContext(), "you just clicked a button",Toast.LENGTH_LONG).show();

            }
        });
    }

    private void validate() {
        firstname = etFirstName.getText().toString().trim();
        surname = etSurname.getText().toString().trim();
        Username = etUsername.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        location = etloc.getText().toString().trim();
        birthday = etBirthDay.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        //spGender.set

        if (TextUtils.isEmpty(firstname)) {
             message = "First name cannot be empty";
            etFirstName.setError(message);
            return;
        }

        if (TextUtils.isEmpty(surname)) {
            message = "First name cannot be empty";
            etSurname.setError(message);
            return;

        }

        if (!util.isValidEmail(getApplicationContext(), email)) {
            message = "Email Cannot be empty";
            etEmail.setError(message);
            return;

        }

        if (!util.isValidPhoneNumber(getApplicationContext(), email)) {
            message = "phone number cannot be empty";
            etPhone.setError(message);
            return;}

        if (phone.length() < 11){
            etPhone.setError("incomplete phone number");
            return;}

        if (!phone.startsWith("0") ) {
            etPhone.setError("incomplete phone number");
            return;
        }

        //if (TextUtils.isEmpty())

        // if (password != confirm)
        }









    }

