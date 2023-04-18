package com.campussafetyapp.iitridesafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        loginButton = (Button)findViewById(R.id.loginButton);
    }

    public void login(View view){
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
}