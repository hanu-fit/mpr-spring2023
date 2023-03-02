package edu.hanu.viewpersistencedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText edtName = findViewById(R.id.edtName);
        String name = edtName.getText().toString();

        outState.putString("name", name);
        Log.d("Dennis", "onSaveInstanceState: " + name);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String name = savedInstanceState.getString("name");

        EditText edtName = findViewById(R.id.edtName);
        edtName.setText(name);
        Log.d("Dennis", "onRestoreInstanceState: " + name);
    }
}