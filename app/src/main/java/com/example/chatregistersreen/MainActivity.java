package com.example.chatregistersreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chatregistersreen.database.DataBaseHelper;
import com.example.chatregistersreen.database.model.Registration;

public class MainActivity extends AppCompatActivity {

    private EditText etFirstName , etSurname ,etPhone,  etUsername, etEmail, etPassword,etBirthDay ,  etloc  ;
    private Button btnSignUp ;
    private String  firstname , surname , email ,phone,Username, birthday, location ,password ,gender, fullName ;
    private Spinner spGender;
    private String message;
    //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.gender,R.layout.spinner);
    //private ImageButton ibPic;

    Utils util;
   DataBaseHelper db;



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
        spGender = findViewById(R.id.spGender);
        btnSignUp = findViewById(R.id.btnSignup);


        util = new Utils();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent reg = new Intent(MainActivity.this , DashBoard.class);
                //startActivity(reg);

                validate();
            }
        });
    }

    private void validate() {

        db = new DataBaseHelper(getApplicationContext());

        Registration reg = new Registration(fullName , location , email , phone , password);


        fullName = firstname + " " + surname;
        firstname = etFirstName.getText().toString().trim();
        surname = etSurname.getText().toString().trim();
        Username = etUsername.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        location = etloc.getText().toString().trim();
        birthday = etBirthDay.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        gender= spGender.getItemAtPosition(spGender.getSelectedItemPosition()).toString();

        //spGender.set

        if (TextUtils.isEmpty(firstname)) {
             message = "First name cannot be empty";
            etFirstName.setError(message);
            return;
        }

        if (TextUtils.isEmpty(surname)) {
            message = "First name cannot be empty";
            etSurname.setError(message);
            return;}

            if (TextUtils.isEmpty(Username)) {
                message = "Username cannot be empty";
                etSurname.setError(message);
                return;

        }

        if (!util.isValidEmail(getApplicationContext(), email)) {
            message = "Email Cannot be empty";
            etEmail.setError(message);
            return;

        }

        if (!util.isValidPhoneNumber(getApplicationContext(), phone)) {
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
        else {
            try {
                db.insertUser(fullName, phone, location, email, password);
                db.close();
            }

            catch (Exception e) {}

            finally {
                Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();

            }



//            db.insertUser(fullName, phone, location, email, password);
//            //Log.d("Successful" , db.insertUser(fullName, phone, location, email, password));
//            db.close();

//            startActivity(new Intent(MainActivity.this , DashBoard.class));
            Intent intent = new Intent(this, DashBoard.class);


            Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_LONG).show();


            intent.putExtra("Full_Name", fullName);
            intent.putExtra("Email", email );
            intent.putExtra("Phone_Number" , phone );
            intent.putExtra("Username", Username);
            intent.putExtra("Birthday", birthday);
            intent.putExtra("Gender", gender);

            startActivity(intent);


        }

        //if (TextUtils.isEmpty())

        // if (password != confirm)
        }









    }

