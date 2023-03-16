package edu.hanu.myfriendswithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import edu.hanu.myfriendswithdb.models.Friend;

public class AddFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtPhoneNo = findViewById(R.id.edtPhoneNo);
        EditText edtEmail = findViewById(R.id.edtEmail);

        ImageButton imbOK = findViewById(R.id.imbOK);
        imbOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String phoneNo = edtPhoneNo.getText().toString();
                String email = edtEmail.getText().toString();

                Friend friend = new Friend(name, phoneNo, email);
                // TODO: save into db

                finish();
            }
        });

        ImageButton imbCancel = findViewById(R.id.imbCancel);
        imbCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: confirm
                finish();
            }
        });
    }
}