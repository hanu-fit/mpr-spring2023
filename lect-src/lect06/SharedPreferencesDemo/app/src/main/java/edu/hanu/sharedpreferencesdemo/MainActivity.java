package edu.hanu.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get refs
        EditText edtMessage = findViewById(R.id.edtMessage);
        TextView tvMessage = findViewById(R.id.tvMessage);

        // get saved message from shared preferences (if any)
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String message = sharedPreferences.getString("message", "Hello World!");
        tvMessage.setText(message);

        // handle events
        Button btnSet = findViewById(R.id.btnSet);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get entered message
                String message = edtMessage.getText().toString();

                // saved into shared preferences
                sharedPreferences
                        .edit()
                        .putString("message", message)
                        .apply();

                // show message
                tvMessage.setText(message);
            }
        });
    }
}