package com.example.languageeducationlab2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.languageeducationlab2.R;
import com.example.languageeducationlab2.WordsMapProcessor;

public class MainActivity extends AppCompatActivity {

    private static WordsMapProcessor wordsMapProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

}