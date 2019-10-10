package com.eostek.memeorydump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crash1(View view) {
        startActivity(new Intent(this, Crash1.class));
    }

    public void crash2(View view) {
        startActivity(new Intent(this, Crash2.class));
    }

    public void crash3(View view) {
        startActivity(new Intent(this, Crash3.class));
    }
}
