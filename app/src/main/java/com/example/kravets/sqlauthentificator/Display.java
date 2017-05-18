package com.example.kravets.sqlauthentificator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Kravets on 17.05.2017.
 */
public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String userName = getIntent().getStringExtra("Username");
        TextView welc = (TextView) findViewById(R.id.welcome);
        welc.setText(userName);
    }

    public void onButtonClick(View v){


        if (v.getId()==R.id.logoutBtn)
        {
            Intent i = new Intent(Display.this, MainActivity.class);
            startActivity(i);
        }
    }


}
