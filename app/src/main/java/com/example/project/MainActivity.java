package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences settings;
    Button switchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        switchActivity = findViewById(R.id.switch_acitivity_button);

        settings = getSharedPreferences("shared_prefs", MODE_PRIVATE);

    }

    public void onClickListener(View v) {
        startActivity(new Intent(this, EditPreferenceActivity.class));
    }

    protected void onResume() {
        super.onResume();
    }

}
