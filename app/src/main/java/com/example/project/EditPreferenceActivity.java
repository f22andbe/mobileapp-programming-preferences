package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditPreferenceActivity extends AppCompatActivity {

    EditText field;
    SharedPreferences preferences;
    SharedPreferences.Editor preferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_pref);

        field = findViewById(R.id.edit_field);
        preferences = getSharedPreferences("shared_prefs", MODE_PRIVATE); //get a reference to the shared preferences
        preferenceEditor = preferences.edit(); // get an preference editor object

    }

    public void onClickListener(View v) {
        String fieldText = field.getText().toString(); //get string from EditText field
        Log.d("EditActivity:onClickListener", fieldText);
        preferenceEditor.putString("email", fieldText);//write this string together with key "email"
        preferenceEditor.apply(); //apply the updated preference
        finish(); //exit activity
    }


}
