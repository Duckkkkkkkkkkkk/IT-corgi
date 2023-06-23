package com.example.it_corgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void openAboutPage(View view) {
        Intent intent1 = new Intent(this, About.class);
        startActivity(intent1);
    }

    public void openContactsPage(View view) {
        Intent intent2 = new Intent(this, Contacts.class);
        startActivity(intent2);
    }
    public void openMainPage(View view) {
        Intent intent3 = new Intent(this, MainActivity.class);
        startActivity(intent3);
    }

}