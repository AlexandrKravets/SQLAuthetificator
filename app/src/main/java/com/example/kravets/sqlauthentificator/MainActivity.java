package com.example.kravets.sqlauthentificator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View v){
     if (v.getId() == R.id.logInBtn)
     {
         EditText name = (EditText)findViewById(R.id.TFUserName);
         String strName = name.getTag().toString();
         Intent i = new Intent(MainActivity.this, Display.class);
         i.putExtra("Username",strName);
         startActivity(i);
     }

     if (v.getId()==R.id.bRegister)
     {
         Intent i = new Intent(MainActivity.this, RegisterUserActivity.class);

         startActivity(i);
     }
   }
}
