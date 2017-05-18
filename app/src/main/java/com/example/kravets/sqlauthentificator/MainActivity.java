package com.example.kravets.sqlauthentificator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MySQLiteHelper helper = new MySQLiteHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View v){
     if (v.getId() == R.id.logInBtn)
     {
         EditText name = (EditText)findViewById(R.id.TFUserName);
         String strName = name.getText().toString();
         EditText pass = (EditText)findViewById(R.id.TFPassword);
         String strPass = pass.getText().toString();

         String password = helper.searchPass(strName);

         if (strPass.equals(password))
         {
             Intent i = new Intent(MainActivity.this, Display.class);
             i.putExtra("Username",strName);
             startActivity(i);
         }
         else
         {
             // popup message
             Toast message = Toast.makeText(MainActivity.this, "Username and password don't match", Toast.LENGTH_SHORT);
             message.show();
         }

     }

     if (v.getId()==R.id.regBtn)
     {
         Intent i = new Intent(MainActivity.this, RegisterUserActivity.class);
         startActivity(i);
     }
   }
}
