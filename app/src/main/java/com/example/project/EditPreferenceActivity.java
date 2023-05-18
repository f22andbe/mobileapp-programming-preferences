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
        preferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
        preferenceEditor = preferences.edit();

    }

    public void onClickListener(View v) {
        String fieldText = field.getText().toString();
        Log.d("EditActivity:onClickListener", fieldText);
        preferenceEditor.putString("email", fieldText);
        preferenceEditor.apply();
        finish();
    }


}
