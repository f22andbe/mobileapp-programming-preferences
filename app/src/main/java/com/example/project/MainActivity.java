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
        Toolbar toolbar = findViewById(R.id.toolbar); //read in toolbar
        setSupportActionBar(toolbar);
        switchActivityButton = findViewById(R.id.switch_acitivity_button); //read in button
        showPref = findViewById(R.id.show_pref); //read in textview to show preference

        settings = getSharedPreferences("shared_prefs", MODE_PRIVATE); // get object of type  SharedPreferences
    }

    /* clicklistener for switchActivityButton, creates new activity where
     * preference editing happens
     */
    public void onClickListener(View v) {
        startActivity(new Intent(this, EditPreferenceActivity.class));
    }

    protected void onResume() {
        super.onResume();

        String emailSetting = settings.getString("email", "email preference isn't set"); // get value stored with key "email"
        showPref.setText(emailSetting); // set the new value in the textview
        Log.d("onResume: emailSetting:", emailSetting);
        Log.d("onResume: text of TextView:", showPref.getText().toString());
        showPref.setVisibility(View.VISIBLE);
    }

}

