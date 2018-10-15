package com.example.uzzal.sqliteprojecgithub_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etEmail, etUsername, etPassword;
    Button btnSignUp;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etName = (EditText) findViewById(R.id.editTextName_id_2);
        etEmail = (EditText) findViewById(R.id.editTextEmail_id_2);
        etUsername = (EditText) findViewById(R.id.editTextUserName_id_2);
        etPassword = (EditText) findViewById(R.id.editTextPassword_id_2);


        userDetails = new UserDetails();
        btnSignUp = (Button) findViewById(R.id.buttonSignup_id_2);
        btnSignUp.setOnClickListener(this);
        databaseHelper = new DatabaseHelper(this);




    }

    @Override
    public void onClick(View v) {

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String userName = etUsername.getText().toString();
        String password = etPassword.getText().toString();


        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUserName(userName);
        userDetails.setPassword(password);


        long rowId = databaseHelper.insertData(userDetails);
        
        if(rowId>0){

            Toast.makeText(this, "Row "+rowId+" id is Successfully inserted", Toast.LENGTH_SHORT).show();
            
        }else {

            Toast.makeText(this, "Unsuccessfully insertion failed", Toast.LENGTH_SHORT).show();
        }

    }
}
