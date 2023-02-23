package edu.hanu.multiactivitydemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    private Button btnApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // get passed data
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        // say hello
        TextView tvHello = findViewById(R.id.tvHello);
        tvHello.setText("Hello " + name + "!");

        // contact Codee
        btnApply = findViewById(R.id.btnApply);
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                // phone
//                Uri number = Uri.parse("tel:0358877210");
//                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

//                // email
//                Intent emailIntent = new Intent(Intent.ACTION_SEND);
//
//                emailIntent.setType("plain/text");
//                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "codee.hanu@gmail.com" });
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
//                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email content");
//
//                startActivity(emailIntent);

                // confirm
                Intent confirmIntent = new Intent(ThirdActivity.this, ConfirmActivity.class);
                startActivityForResult(confirmIntent, 102);
            }
        });

        // more: https://developer.android.com/training/basics/intents/sending#java
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 102) {
            btnApply.setText("Rock!");
        }
    }
}