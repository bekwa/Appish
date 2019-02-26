package com.example.chatregistersreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity  {

    private TextView tvemail, tvfullname ,tvusername, tvbday , tvgender,tvphoneNum;
    private String fullname, email , username, bday , gender, phoneNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        tvemail = findViewById(R.id.tvEmail);
        tvbday = findViewById(R.id.tvBday);
        tvfullname=findViewById(R.id.tvFullName);
        tvusername = findViewById(R.id.tvUsername);
        tvphoneNum = findViewById(R.id.tvPhoneNum);
        tvgender=findViewById(R.id.tvGender2);


        Intent intent = getIntent();
        fullname =  intent.getStringExtra("Full_Name");
        email = intent.getStringExtra("Email");
        username = intent.getStringExtra("Username");
        bday = intent.getStringExtra("Birthday");
        phoneNum = intent.getStringExtra("Phone_Number");
        gender = intent.getStringExtra("Gender");

        tvfullname.setText(fullname);
        tvbday.setText(bday);
        tvemail.setText(email);
        tvusername.setText(username);
        tvphoneNum.setText(phoneNum);
        tvgender.setText(gender);


    }

}
