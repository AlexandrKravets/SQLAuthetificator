package com.example.kravets.sqlauthentificator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Kravets on 17.05.2017.
 */
public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        String userName = getIntent().getStringExtra("Username");
    }
}
