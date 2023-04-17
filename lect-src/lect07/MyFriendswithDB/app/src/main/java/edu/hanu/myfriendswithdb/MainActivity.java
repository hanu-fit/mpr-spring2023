package edu.hanu.myfriendswithdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.myfriendswithdb.adapters.FriendAdapter;
import edu.hanu.myfriendswithdb.db.DbHelper;
import edu.hanu.myfriendswithdb.models.Friend;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dataset
        // TODO: load friends from db
        List<Friend> friends = loadFriends();

//        List<Friend> friends = new ArrayList<>();
//        friends.add(new Friend("Cong Nguyen", "0358877210", "congnv@hanu.edu.vn"));
//        friends.add(new Friend("Dennis Nguyen", "0358877210", "congnv@hanu.edu.vn"));
//        friends.add(new Friend("Little Bee", "0358877210", "congnv@hanu.edu.vn"));
//        friends.add(new Friend("Shinichi_92", "0358877210", "congnv@hanu.edu.vn"));

        // recycler view
        RecyclerView rvFriends = findViewById(R.id.rvFriends);
        // how recycler view layout items inside
        rvFriends.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // bridge dataset -> recycler view = adapter
        FriendAdapter friendAdapter = new FriendAdapter(friends);
        rvFriends.setAdapter(friendAdapter);

        // new friend
        ImageButton imbAddFriend = findViewById(R.id.imbAddFriend);
        imbAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddFriendActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<Friend> loadFriends() {
        // connect db
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // select all friends
        List<Friend> friends = new ArrayList<>();

        String sql = "SELECT * FROM friends";
        Cursor cursor = db.rawQuery(sql, null);

        int idIndex = cursor.getColumnIndex("id");
        int nameIndex = cursor.getColumnIndex("name");
        int emailIndex = cursor.getColumnIndex("email");
        int phoneNoIndex = cursor.getColumnIndex("phoneNo");

        // foreach returned record in cursor
        while (cursor.moveToNext()) {
            // get id, name, email, phoneNo
            long id = cursor.getLong(idIndex);
            String name = cursor.getString(nameIndex);
            String email = cursor.getString(emailIndex);
            String phoneNo = cursor.getString(phoneNoIndex);

            // create new Friend object
            Friend friend = new Friend(id, name, phoneNo, email);

            // add into friends
            friends.add(friend);
        }

        // close connection
        db.close();

        return friends;
    }
}