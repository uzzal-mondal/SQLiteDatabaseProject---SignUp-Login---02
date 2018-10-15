package com.example.uzzal.sqliteprojecgithub_2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextUserName, editTextPassword;
    private Button buttonSignIn, buttonSignUp;

   DatabaseHelper databaseHelper;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
      SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();

      editTextUserName = (EditText) findViewById(R.id.editUserName_id);
      editTextPassword = (EditText) findViewById(R.id.editTextPassword_id);

      buttonSignIn = (Button) findViewById(R.id.buttonSignIn_id);
      buttonSignUp = (Button) findViewById(R.id.buttonSignUp_id);




      buttonSignIn.setOnClickListener(this);
      buttonSignUp.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {


        String name = editTextUserName.getText().toString();
        String password = editTextPassword.getText().toString();

        if(v.getId()==R.id.buttonSignIn_id){

            Boolean result = databaseHelper.findPassword(name,password);

            if(result==true){
                Intent intent = new Intent(MainActivity.this,DataActivity.class);
                startActivity(intent);

            }else {

                Toast.makeText(this, "Unsuccessfully Login \n Id & password Didn't Match", Toast.LENGTH_SHORT).show();


            }


        }


        else if(v.getId()==R.id.buttonSignUp_id){

            Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }

}
