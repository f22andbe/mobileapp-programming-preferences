package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences settings;
    Button switchActivityButton;
    TextView showPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        switchActivityButton = findViewById(R.id.switch_acitivity_button);
        showPref = findViewById(R.id.show_pref);

        settings = getSharedPreferences("shared_prefs", MODE_PRIVATE);
    }

    public void onClickListener(View v) {
        startActivity(new Intent(this, EditPreferenceActivity.class));
    }

    protected void onResume() {
        super.onResume();

        String emailSetting = settings.getString("email", "email preference isn't set");
        showPref.setText(emailSetting);
        Log.d("onResume: emailSetting:", emailSetting);
        Log.d("onResume: text of TextView:", showPref.getText().toString());
        showPref.setVisibility(View.VISIBLE);
    }

}

